package sg.nets.com.singpass.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Random;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jwt.SignedJWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

public class Security {
	
	private static final Logger logger = Logger.getLogger(Security.class);
	
	public Security() {		
	}

	public String decodeJwt(String accessToken, String publicCertPath) {
	    	
    	PublicKey key = null;
    	
    	try {
	    	CertificateFactory fact = CertificateFactory.getInstance("X.509");
	    	FileInputStream is = new FileInputStream (publicCertPath);
	    	X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
	    	key = cer.getPublicKey();
    	}catch(CertificateException e) {
    		e.printStackTrace();
    	}catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	logger.info(publicCertPath);
    	logger.info(key);
    	
    	Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(accessToken).getBody();
		return body.getSubject();
    }
	
	public String decryptJWE(String jweToken,String privateKeyPath) {
    	
		String payload = "";
		//decrypt JWE
		JWEObject jweObject;
		try {
			jweObject = JWEObject.parse(jweToken);
			
			RSADecrypter decrypter = new RSADecrypter(readPrivateKey(privateKeyPath));
	        jweObject.decrypt(decrypter);
	        
	        // Extract payload
	        SignedJWT signedJWT = jweObject.getPayload().toSignedJWT();
	        payload = signedJWT.getPayload().toJSONObject().toString();
	        System.out.println("PersonData: "+payload);
		}catch(Exception e) {
			e.printStackTrace();
	        throw new RuntimeException(e);
		}
		
    	return payload;
    }
	
	public String generateSHA256withRSAHeader(String url, String params, String method, 
			String strContentType, String appId, String privateKeyPath, String keyCertPassphrase,String publicKeyPath) throws JsonMappingException, JsonParseException, IOException{
	
		long nonce = generateNonceValue();
		long timestamp = System.currentTimeMillis();
		
		// Remove params unless Content-Type is "application/x-www-form-urlencoded"
		if (method == "POST" && strContentType != "application/x-www-form-urlencoded") {
			params = "";
		}
		
		String baseString = ParameterStringBuilder.constractFormulatedBaseString(url,params, method, nonce, timestamp, appId);
		logger.info(baseString);
			
		String strApexHeader = "";
		try {
			RSAPrivateKey key = readPrivateKey(privateKeyPath);
			
			String signature = createSign(baseString, key);
			
			boolean isVerified = verify(baseString, signature, readPublicKey(publicKeyPath));
			
			logger.info("Verify Signature");
			logger.info(isVerified);
			
			logger.info("Digital Signature:\r\n" + 
					"Signature produced by signing the above Base String with your private key.");
			logger.info(signature);
			
			strApexHeader = "PKI_SIGN timestamp=\"" + timestamp +
				    "\",nonce=\"" + nonce +
				    "\",app_id=\"" + appId +
				    "\",signature_method=\"RS256\"" +
				    ",signature=\"" + signature +
				    "\"";
			
			logger.info("StrApexHeader");
			logger.info(strApexHeader);
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}
		
		return strApexHeader;
	}
	
	public RSAPrivateKey readPrivateKey(String privateKeyPath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
		
		Path path = Paths.get(privateKeyPath);
	    String key = new String(Files.readAllBytes(path), Charset.defaultCharset());
	    
	    logger.info("Private key");
		logger.info(key);
	    
	    String privateKeyPEM = key
	      .replace("-----BEGIN PRIVATE KEY-----", "")
	      .replaceAll(System.lineSeparator(), "")
	      .replace("-----END PRIVATE KEY-----", "");
	 
	    byte[] encoded = org.apache.commons.codec.binary.Base64.decodeBase64(privateKeyPEM);
	 
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
	    return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
	}		
	
	public PublicKey readPublicKey(String publicKeyPath) {
				
    	PublicKey key = null;
    	
    	try {
	    	CertificateFactory fact = CertificateFactory.getInstance("X.509");
	    	FileInputStream is = new FileInputStream (publicKeyPath);
	    	X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
	    	key = cer.getPublicKey();
    	}catch(CertificateException e) {
    		e.printStackTrace();
    	}catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	logger.info("ReadPublicKey Method: ");
    	logger.info(publicKeyPath);
    	logger.info(key);
    	
    	return key;
	}
	
	public boolean verify(String plainText, String signature, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException,SignatureException {
	    Signature publicSignature = Signature.getInstance("SHA256withRSA");
	    publicSignature.initVerify(publicKey);
	    publicSignature.update(plainText.getBytes());

	    byte[] signatureBytes = Base64.getDecoder().decode(signature);

	    return publicSignature.verify(signatureBytes);
	}		
	
	public String createSign(String baseString, PrivateKey privateKey) {		
		String finalStr = "";
		try {
			Signature sig = Signature.getInstance("SHA256withRSA");		
			sig.initSign(privateKey);
			sig.update(baseString.getBytes());
			byte[] signedData = sig.sign();
			finalStr = Base64.getEncoder().encodeToString(signedData);
		}catch(NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
		}
		return finalStr;
	}
	
	private long generateNonceValue() {
		
		long nonce = 0L;
		try {
			Random rand = SecureRandom.getInstance ("SHA1PRNG");
			nonce = rand.nextLong();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return nonce;
	}
}

package sg.nets.com.singpass.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class AuthParam implements Serializable{

	private static final long serialVersionUID = -6378987196275995694L;
	
	@JsonProperty("grant_type")
	private String grantType;
		
	private String code;
	
	@JsonProperty("redirect_uri")
	private String redirectUri;
	
	@JsonProperty("client_id")
	private String clientId;
		
	private String attributes;
	
	@JsonProperty("client_secret")
	private String clientSecret;
	
	@JsonProperty("app_id")
	private String appId;
	
	
	private long nonce;
	
	@JsonProperty("signature_method")
	private String signatureMethod;
		
	private long timestamp;
	
	public AuthParam() {		
	}			

	public AuthParam(String grantType, String code, String redirectUri, String clientId, String attributes,
			String clientSecret, String appId, long nonce, String signatureMethod, long timestamp) {
		super();
		this.grantType = grantType;
		this.code = code;
		this.redirectUri = redirectUri;
		this.clientId = clientId;
		this.attributes = attributes;
		this.clientSecret = clientSecret;
		this.appId = appId;
		this.nonce = nonce;
		this.signatureMethod = signatureMethod;
		this.timestamp = timestamp;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public long getNonce() {
		return nonce;
	}

	public void setNonce(long nonce) {
		this.nonce = nonce;
	}

	public String getSignatureMethod() {
		return signatureMethod;
	}

	public void setSignatureMethod(String signatureMethod) {
		this.signatureMethod = signatureMethod;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}		

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "AuthParam [grantType=" + grantType + ", code=" + code + ", redirectUri=" + redirectUri + ", clientId="
				+ clientId + ", attributes=" + attributes + ", clientSecret=" + clientSecret + ", appId=" + appId
				+ ", nonce=" + nonce + ", signatureMethod=" + signatureMethod + ", timestamp=" + timestamp + "]";
	}
}

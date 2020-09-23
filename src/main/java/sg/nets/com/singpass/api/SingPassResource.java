package sg.nets.com.singpass.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import sg.nets.com.singpass.model.AuthResponse;
import sg.nets.com.singpass.model.Person;
import sg.nets.com.singpass.util.Config;
import sg.nets.com.singpass.util.FullResponseBuilder;

public class SingPassResource {

	private static final Logger logger = Logger.getLogger(SingPassResource.class);
	private Config config;
	private Properties properties;
    
	public SingPassResource() {    
    	this.config = new Config();
    	this.properties = config.getProperties();
    }
        
    @POST
    @Produces("application/json")
    public Response getPerson(String code) throws IOException {      	    	
    	
    	AuthResponse authResponse = createTokenRequest(code);    	    	
    	
    	ResponseBuilder builder = null;
    	
    	if(authResponse.getCode() > 299) {
    		
    		builder = Response.status(authResponse.getCode(), authResponse.getMessage());
    	}else {
    		
    		logger.info("Access Token: "+authResponse.getAccess_token());
    		
    		String body = decodeJwt(authResponse.getAccess_token());    		
    		Person data = createPersonRequest(body,authResponse.getAccess_token());
            builder = Response.ok(data);
    	}  	    	               
                
        builder.header("Access-Control-Allow-Origin", "*");
        builder.header("Access-Control-Max-Age", "3600");
        builder.header("Access-Control-Allow-Methods", "*");
        builder.header(
                "Access-Control-Allow-Headers",
                "X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
        return builder.build();
    }
    
    private String decodeJwt(String accessToken) {
    	
    	logger.info(config.getSslDir());
    	
    	PublicKey key = null;
    	
    	try {
	    	CertificateFactory fact = CertificateFactory.getInstance("X.509");
	    	FileInputStream is = new FileInputStream (config.getSslDir());
	    	X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
	    	key = cer.getPublicKey();
    	}catch(CertificateException e) {
    		e.printStackTrace();
    	}catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}    	    
    	
    	Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(accessToken).getBody();

		System.out.println("Issuer     : " + body.getIssuer());
		System.out.println("Subject    : " + body.getSubject());
		System.out.println("Expiration : " + body.getExpiration());
		logger.info(body.toString());
		
		return body.getSubject();		
    }
    
    private Person createPersonRequest(String sub,String accessToken) {
    	
    	Person person = new Person();
    	
    	try {
    		
    		String apiPerson = properties.getProperty("MYINFO_API_PERSON")+"/"+sub+"/";
    		
    		HttpUrl.Builder urlBuilder = HttpUrl.parse(apiPerson).newBuilder();
    		urlBuilder.addQueryParameter("client_id", properties.getProperty("MYINFO_APP_CLIENT_ID"));
    		urlBuilder.addQueryParameter("attributes", properties.getProperty("SINGPASS_ATTRIBUTES"));
    		String url = urlBuilder.build().toString();
    		
    		OkHttpClient client = new OkHttpClient().newBuilder()
    			  .build();
    			Request request = new Request.Builder()
    			  .url(url)    			  
    			  .method("GET", null)
    			  .addHeader("Authorization", "Bearer "+accessToken)
    			  .addHeader("Cache-Control", "no-cache")
    			  .addHeader("Content-Type", "application/json")    			  
    			  .build();
    			okhttp3.Response response = client.newCall(request).execute();
    			
    			/*person = FullResponseBuilder.getPersonContent(response.body().byteStream());    			    	
    			logger.info(person);*/
    			
    			String jsonVehicle = "\"vehicles\":[{\"roadtaxexpirydate\":{\"value\":\"2019-12-12\"},\"engineno\":{\"value\":\"M13A1837453\"},\"attachment3\":{\"value\":\"ROOF TENT\"},\"effectiveownership\":{\"value\":\"2013-05-19T12:28:19\"},\"scheme\":{\"value\":\"ROPC - REVISED OFF-PEAK CAR\"},\"powerrate\":{\"value\":1.8},\"source\":\"1\",\"primarycolour\":{\"value\":\"BLACK\"},\"type\":{\"value\":\"Station Wagon/Jeep/Land Rover\"},\"vehicleno\":{\"value\":\"SDF1235A\"},\"coeexpirydate\":{\"value\":\"2023-05-19\"},\"chassisno\":{\"value\":\"ZC11S1735800\"},\"noxemission\":{\"value\":0.015678},\"model\":{\"value\":\"KIA SEDONA\"},\"openmarketvalue\":{\"value\":17493.35},\"coemission\":{\"value\":0.135982},\"attachment2\":{\"value\":\"SUN ROOF\"},\"attachment1\":{\"value\":\"BICYCLE CARRIER\"},\"make\":{\"value\":\"KIA\"},\"pmemission\":{\"value\":0.194},\"originalregistrationdate\":{\"value\":\"2012-08-19\"},\"yearofmanufacture\":{\"value\":\"2013\"},\"vpc\":{\"value\":\"\"},\"enginecapacity\":{\"value\":1500},\"classification\":\"C\",\"nooftransfers\":{\"value\":1},\"propellant\":{\"value\":\"Petrol-Electric\"},\"co2emission\":{\"value\":155},\"motorno\":{\"value\":\"M13A1837453\"},\"minimumparfbenefit\":{\"value\":2500},\"thcemission\":{\"value\":0.198765},\"firstregistrationdate\":{\"value\":\"2013-05-19\"},\"lastupdated\":\"2020-09-10\",\"maximumunladenweight\":{\"value\":1800},\"coecategory\":{\"value\":\"C - GOODS VEHICLE & BUS\"},\"maximumladenweight\":{\"value\":2200},\"secondarycolour\":{\"value\":\"\"},\"iulabelno\":{\"value\":\"1234567890\"},\"quotapremium\":{\"value\":14000},\"status\":{\"code\":\"2\",\"desc\":\"DE-REGISTERED\"}}]";
    			String json = FullResponseBuilder.getStrResponseContent(response.body().byteStream());
    			json = json.substring(0,json.length()-1) + "," + jsonVehicle +"}";
    			logger.info(json);
    			
    			ObjectMapper mapper = new ObjectMapper();
    			person = mapper.readValue(json, Person.class);
    			//logger.info(person);    			    			
    			
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	return person;
    }
    
    private AuthResponse createTokenRequest(String code) {
    	
    	AuthResponse authResponse = new AuthResponse();
    	
    	try {
    		
    		String content = "grant_type=authorization_code&"
    				+ "code="+code+"&"
    				+ "redirect_uri="+properties.getProperty("MYINFO_APP_REDIRECT_URL")+"&"
    				+ "client_id="+properties.getProperty("MYINFO_APP_CLIENT_ID")+"&"
    				+ "client_secret="+properties.getProperty("MYINFO_APP_CLIENT_SECRET")+"";
    		
    		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    		RequestBody body = RequestBody.create(content,mediaType);    		    		    		
    		
    		OkHttpClient client = new OkHttpClient().newBuilder()
    			  .build();
    			Request request = new Request.Builder()
    			  .url(properties.getProperty("MYINFO_API_TOKEN"))    			  
    			  .method("POST", body)    			  
    			  .addHeader("Cache-Control", "no-cache")
    			  .addHeader("Content-Type", "application/x-www-form-urlencoded")    			  
    			  .build();
    			okhttp3.Response response = client.newCall(request).execute();
    			
    			authResponse = FullResponseBuilder.getResponseContent(response.body().byteStream());
    			    			    		
    			logger.info("=============OkHttp3================");
    			logger.info(authResponse.toString());
    			
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	return authResponse;
    }
    
    /*private AuthResponse createTokenRequest(String code) {
    	
    	AuthResponse authResponse = new AuthResponse();    	
    	
    	try {
	    	URL url = new URL(properties.getProperty("MYINFO_API_TOKEN"));
	    	HttpURLConnection con = (HttpURLConnection) url.openConnection();	    	
	    	con.setRequestMethod("POST");
	    	con.setRequestProperty("Cache-Control", "no-cache");
	    	con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    	
	    	Map<String, String> parameters = new HashMap<>();
	    	parameters.put("grant_type", "authorization_code");
	    	parameters.put("code", code);
	    	parameters.put("redirect_uri", properties.getProperty("MYINFO_APP_REDIRECT_URL"));
	    	parameters.put("client_id", properties.getProperty("MYINFO_APP_CLIENT_ID"));
	    	parameters.put("client_secret", properties.getProperty("MYINFO_APP_CLIENT_SECRET")); 
	    	
	    	con.setDoOutput(true);
	    	DataOutputStream out = new DataOutputStream(con.getOutputStream());
	    	out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
	    	out.flush();
	    	out.close();
	    	
	    	authResponse = FullResponseBuilder.getResponseContent(con);
	    	
	    	logger.info("=============HttpUrlConnection================");
	    	logger.info(authResponse.toString());	   
	    	
	    	con.disconnect();
	    	
    	}catch(MalformedURLException | ProtocolException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return authResponse;
    }*/
    
    /*@GET
   	@Produces({ "application/json" })
    public Response checkPerson(@QueryParam("code") String code) throws IOException, JSONException {
    	SingPass data = new SingPass();
        data.setFirstname( "Fredy" );
        data.setLastname( "Kusumah" );
        data.setEmail( "kusumah.dharma@izeno.com	" );
        data.setBirthdate( "09/10/1989" );

        data.setCode( code );
        return Response.ok( data ).build();
    }*/
}

package sg.nets.com.singpass.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.logging.Logger;
import org.keycloak.models.KeycloakSession;

import sg.nets.com.singpass.model.SingPass;
import sg.nets.com.singpass.util.FullResponseBuilder;
import sg.nets.com.singpass.util.ParameterStringBuilder;

public class SingPassResource {

	private KeycloakSession session;
    private final String realmName;
    private static final Logger logger = Logger.getLogger(SingPassResource.class);
    
    private final String MYINFO_API_TOKEN= "https://sandbox.api.myinfo.gov.sg/com/v3/token";
    private final String MYINFO_APP_REDIRECT_URL= "http://localhost:3001/callback";
    private final String MYINFO_APP_CLIENT_ID= "STG2-MYINFO-SELF-TEST";
    private final String MYINFO_APP_CLIENT_SECRET= "44d953c796cccebcec9bdc826852857ab412fbe2";

    public SingPassResource(KeycloakSession session) {
        this.session = session;
        String envRealmName = System.getenv("REALM_NAME");
        this.realmName = Objects.isNull(envRealmName) || Objects.equals(System.getenv(envRealmName), "")? "example": envRealmName;
    }
    
    @POST
    //@Path("/post")    
    @Produces("application/json")
    public Response testClient(String code) throws IOException {  
    	
    	createTokenRequest(code);
    	
    	SingPass data = new SingPass();
        data.setFirstname( "Fredy" );
        data.setLastname( "Kusumah" );
        data.setEmail( "kusumah.dharma@izeno.com	" );
        data.setBirthdate( "09/10/1989" );

        data.setCode( code );
    	
        ResponseBuilder builder = Response.ok(data);
        builder.header("Access-Control-Allow-Origin", "*");
        builder.header("Access-Control-Max-Age", "3600");
        builder.header("Access-Control-Allow-Methods", "*");
        builder.header(
                "Access-Control-Allow-Headers",
                "X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
        return builder.build();
    }
    
    private void createTokenRequest(String code) {
    	
    	try {
	    	URL url = new URL(MYINFO_API_TOKEN);
	    	HttpURLConnection con = (HttpURLConnection) url.openConnection();	    	
	    	con.setRequestMethod("POST");
	    	con.setRequestProperty("Cache-Control", "no-cache");
	    	con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    	
	    	Map<String, String> parameters = new HashMap<>();
	    	parameters.put("grant_type", "authorization_code");
	    	parameters.put("code", code);
	    	parameters.put("redirect_uri", MYINFO_APP_REDIRECT_URL);
	    	parameters.put("client_id", MYINFO_APP_CLIENT_ID);
	    	parameters.put("client_secret", MYINFO_APP_CLIENT_SECRET); 
	    	
	    	con.setDoOutput(true);
	    	DataOutputStream out = new DataOutputStream(con.getOutputStream());
	    	out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
	    	out.flush();
	    	out.close();	    		    
	    	
	    	//int status = con.getResponseCode();
	    	logger.info(FullResponseBuilder.getFullResponse(con));
	    	
	    	con.disconnect();
	    	
    	}catch(MalformedURLException | ProtocolException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
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

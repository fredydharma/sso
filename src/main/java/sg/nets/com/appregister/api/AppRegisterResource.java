package sg.nets.com.appregister.api;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Objects;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


import javax.ws.rs.HeaderParam;


import org.jboss.logging.Logger;
import org.keycloak.models.KeycloakSession;

import sg.nets.com.appregister.model.User;


public class AppRegisterResource {

	private KeycloakSession session;
    private final String realmName;
    private static final Logger logger = Logger.getLogger(AppRegisterResource.class);
    
    // private final String MYINFO_API_TOKEN= "https://sandbox.api.myinfo.gov.sg/com/v3/token";
    // private final String MYINFO_APP_REDIRECT_URL= "http://localhost:3001/callback";
    // private final String MYINFO_APP_CLIENT_ID= "STG2-MYINFO-SELF-TEST";
    // private final String MYINFO_APP_CLIENT_SECRET= "44d953c796cccebcec9bdc826852857ab412fbe2";

    public AppRegisterResource(KeycloakSession session) {
        this.session = session;
        String envRealmName = System.getenv("REALM_NAME");
        this.realmName = Objects.isNull(envRealmName) || Objects.equals(System.getenv(envRealmName), "")? "example": envRealmName;
    }

    @POST
   	@Produces({ "application/json" })
    public Response checkPerson( @HeaderParam( "Authorization" ) String authorization ) throws IOException {
    	User data = new User();
        data.setFirstname( "Fredy" );
        data.setLastname( "Kusumah" );
        data.setEmail( "kusumah.dharma@izeno.com	" );
        data.setBirthdate( "09/10/1989" );

        data.setCode( authorization );
        return Response.ok( data ).build();
    }

    @GET
   	@Produces({ "application/json" })
    public Response checkPersonzz(@QueryParam("appregister-code") String code) throws IOException {
    	User data = new User();
        data.setFirstname( "Ferdinand" );
        data.setLastname( "Kusumah" );
        data.setEmail( "kusumah.dharma@izeno.com	" );
        data.setBirthdate( "09/10/1989" );

        data.setCode( code );
        return Response.ok( data ).build();
        
    }
    
}

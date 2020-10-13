package sg.nets.com.singpass.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sg.nets.com.singpass.util.Config;

public class SingPassEnvResource {

	private static final Logger logger = Logger.getLogger(SingPassEnvResource.class);
	private Config config;
	private Properties properties;
    
	public SingPassEnvResource() {    
    	this.config = new Config();
    	this.properties = config.getProperties();
    }
	
	@GET
   	@Produces({ "application/json" })
    public Response getEnvData(){
    	
		Map<String,String> map = new HashMap<>();
		map.put("auth_api_url",properties.getProperty("MYINFO_API_AUTHORISE"));
		map.put("client_id",properties.getProperty("MYINFO_APP_CLIENT_ID"));
		map.put("attributes",properties.getProperty("MYINFO_ATTRIBUTES"));
		map.put("purpose",properties.getProperty("MYINFO_PURPOSE"));
		map.put("state",properties.getProperty("MYINFO_STATE"));
		map.put("redirect_url",properties.getProperty("MYINFO_APP_REDIRECT_URL"));
	
		String json = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(map);
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		logger.info(json);
		
		ResponseBuilder builder = Response.ok( json );
		builder.header("Access-Control-Allow-Origin", "*");
        builder.header("Access-Control-Max-Age", "3600");
        builder.header("Access-Control-Allow-Methods", "*");
        builder.header(
                "Access-Control-Allow-Headers",
                "X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
		
        return builder.build();
    }
}

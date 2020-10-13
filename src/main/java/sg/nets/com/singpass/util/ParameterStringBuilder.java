package sg.nets.com.singpass.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sg.nets.com.singpass.model.AuthParam;

public final class ParameterStringBuilder {
    public static String getParamsString(Map<String, String> params) 
      throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
 
        for (Map.Entry<String, String> entry : params.entrySet()) {
          result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
          result.append("=");
          result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
          result.append("&");
        }
 
        String resultString = result.toString();
        return resultString.length() > 0
          ? resultString.substring(0, resultString.length() - 1)
          : resultString;
    }
    
    public static String paramToJson(String paramIn) {
        paramIn = paramIn.replaceAll("=", "\":\"");
        paramIn = paramIn.replaceAll("&", "\",\"");
        return "{\"" + paramIn + "\"}";
    }
    
    public static String jsonToParam(String paramIn) {
        paramIn = paramIn.replaceAll("\":\"", "=");
        paramIn = paramIn.replaceAll("\",\"", "&");
        return paramIn.substring(2,paramIn.length()-2);        
    }
    
    @SuppressWarnings("unchecked")
	public static String constractFormulatedBaseString(String url,String params, String method,long nonce,long timestamp,String appId) throws JsonMappingException, JsonParseException, IOException{
    	
    	String json = ParameterStringBuilder.paramToJson(params);
		
    	System.out.println("JSON: "+json);
    	
		ObjectMapper mapper = new ObjectMapper();
		AuthParam sortParam = mapper.readValue(json, AuthParam.class);
		sortParam.setAppId(appId);
		sortParam.setNonce(nonce);
		sortParam.setTimestamp(timestamp);
		sortParam.setSignatureMethod("RS256");
		
		System.out.println("ToString Param: "+sortParam);
		
		ObjectMapper objectMapper = new ObjectMapper();
		URIBuilder ub = new URIBuilder();
        Map<String, Object> map =
                objectMapper.convertValue(
                		sortParam, Map.class);               
		        
        map.entrySet().stream().forEach(e -> {
        	if(method.equals("POST")) {
        		if(!e.getKey().equals("attributes")) {
        			ub.addParameter(e.getKey(),e.getValue().toString());
        		}
        	}else if(method.equals("GET")){
        		if(!e.getKey().equals("client_secret") && !e.getKey().equals("code")
        				&& !e.getKey().equals("grant_type") && !e.getKey().equals("redirect_uri")) {
        			ub.addParameter(e.getKey(),e.getValue().toString());
        		}        		
        	}
        });
        
        String baseString = method.toUpperCase() + "&" + url + "&" + URLDecoder.decode(ub.toString().substring(1),"UTF-8");
        
		return baseString;
    }
}

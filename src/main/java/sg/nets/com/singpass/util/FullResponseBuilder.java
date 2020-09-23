package sg.nets.com.singpass.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Response;
import sg.nets.com.singpass.model.AuthResponse;
import sg.nets.com.singpass.model.Person;

public class FullResponseBuilder {
	
	public static String getFullResponse(HttpURLConnection con) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();
        
        int status = con.getResponseCode();
        
        // read status and message
        fullResponseBuilder.append(status)
        .append(" ")
        .append(con.getResponseMessage())
        .append("\n");
        
        // read headers
        con.getHeaderFields().entrySet().stream()
	        .filter(entry -> entry.getKey() != null)
	        .forEach(entry -> {
	            fullResponseBuilder.append(entry.getKey()).append(": ");
	            List<String> headerValues = entry.getValue();
	            Iterator<String> it = headerValues.iterator();
	            if (it.hasNext()) {
	                fullResponseBuilder.append(it.next());
	                while (it.hasNext()) {
	                    fullResponseBuilder.append(", ").append(it.next());
	                }
	            }
	            fullResponseBuilder.append("\n");
	      });
 
        // read response content
		Reader streamReader;		 
		if (status > 299) {
		    streamReader = new InputStreamReader(con.getErrorStream());
		} else {
		    streamReader = new InputStreamReader(con.getInputStream());
		}
		
		BufferedReader in = new BufferedReader(streamReader);
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			fullResponseBuilder.append(inputLine);
		}
		in.close();
 
        return fullResponseBuilder.toString();
    }
	
	public static String getFullResponse(Response response) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();
        
        int status = response.code();
        
        // read status and message
        fullResponseBuilder.append(status)
        .append(" ")
        .append(response.message())
        .append("\n");
        
        response.headers().toString();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(response.body().byteStream()));
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			fullResponseBuilder.append(inputLine);
		}
		in.close();
 
        return fullResponseBuilder.toString();
    }
    
    public static AuthResponse getResponseContent(HttpURLConnection con) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();
 
        int status = con.getResponseCode();        
        
        // read response content
		Reader streamReader;		 
		if (status > 299) {
		    streamReader = new InputStreamReader(con.getErrorStream());
		} else {
		    streamReader = new InputStreamReader(con.getInputStream());
		}
		
		BufferedReader in = new BufferedReader(streamReader);
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			fullResponseBuilder.append(inputLine);			
		}
		in.close();
 
		ObjectMapper mapper = new ObjectMapper();    		    		    
    	AuthResponse response = mapper.readValue(fullResponseBuilder.toString(), AuthResponse.class);		    	
    	
        return response;
    }
    
    public static String getStrResponseContent(InputStream stream) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			fullResponseBuilder.append(inputLine);			
		}
		in.close();
 
		
        return fullResponseBuilder.toString();
    }
    
    public static AuthResponse getResponseContent(InputStream stream) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			fullResponseBuilder.append(inputLine);			
		}
		in.close();
 
		ObjectMapper mapper = new ObjectMapper();    		    		    
    	AuthResponse response = mapper.readValue(fullResponseBuilder.toString(), AuthResponse.class);		    	
    	
        return response;
    }
    
    public static Person getPersonContent(InputStream stream) throws IOException {
        StringBuilder fullResponseBuilder = new StringBuilder();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			fullResponseBuilder.append(inputLine);			
		}
		in.close();
 
		ObjectMapper mapper = new ObjectMapper();    		    		    
    	Person response = mapper.readValue(fullResponseBuilder.toString(), Person.class);		    	
    	
        return response;
    }
}
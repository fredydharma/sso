package sg.nets.com.singpass.model;

import java.io.Serializable;

public class AuthResponse implements Serializable{
	private static final long serialVersionUID = -6460270492270064466L;
	private int code;    
	private String message;
    private String access_token;
    private String token_type;
    private String expires_in;
    private String refresh_token;
    private String scope;
    
    public AuthResponse() {    	
    }
    
    public AuthResponse(int code, String message, String access_token, String token_type, String expires_in,
			String refresh_token, String scope) {
		this.code = code;
		this.message = message;
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.scope = scope;
	}
    
    public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AuthResponse [code=" + code + ", message=" + message + ", access_token=" + access_token
				+ ", token_type=" + token_type + ", expires_in=" + expires_in + ", refresh_token=" + refresh_token
				+ ", scope=" + scope + "]";
	}   
}

package sg.nets.com.singpass.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class SingPass implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty
	private String firstname;
	@JsonProperty
	private String lastname;
	@JsonProperty
	private String email;
	@JsonProperty
	private String birthdate;
	@JsonProperty
	private String code;
	
	public SingPass() {
	}
	
	public SingPass( final String lastname, final String firstname, final String email, final String birthdate, final String code ) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthdate = birthdate;
		this.code = code;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}
	
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(final String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return this.birthdate;
	}
	
	public void setBirthdate(final String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}
}

package sg.nets.com.singpass.model;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable{

	private static final long serialVersionUID = -8900551550615275238L;
	
	private Field dob;
	private Field uinfin;
	private Field name;	
	private Field email;	
	private Address regadd;
	private Phone mobileno;
	private List<Vehicle> vehicles;
	
	public Person() {		
	}		
	
	public Person(Field dob, Field uinfin, Field name, Field email, Address regadd,
			Phone mobileno,List<Vehicle> vehicles) {
		this.dob = dob;
		this.uinfin = uinfin;
		this.name = name;
		this.email = email;		
		this.regadd = regadd;
		this.mobileno = mobileno;
		this.vehicles = vehicles;
	}		

	public Phone getMobileno() {
		return mobileno;
	}

	public void setMobileno(Phone mobileno) {
		this.mobileno = mobileno;
	}

	public Address getRegadd() {
		return regadd;
	}

	public void setRegadd(Address regadd) {
		this.regadd = regadd;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Field getUinfin() {
		return uinfin;
	}
	public void setUinfin(Field uinfin) {
		this.uinfin = uinfin;
	}
	public Field getName() {
		return name;
	}
	public void setName(Field name) {
		this.name = name;
	}
	public Field getEmail() {
		return email;
	}
	public void setEmail(Field email) {
		this.email = email;
	}
	
	public Field getDob() {
		return dob;
	}
	public void setDob(Field dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Person [dob=" + dob + ", uinfin=" + uinfin + ", name=" + name + ", email=" + email + ", regadd="
				+ regadd + ", mobileno=" + mobileno + ", vehicles=" + vehicles + "]";
	}	
}

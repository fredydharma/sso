package sg.nets.com.singpass.model;

import java.io.Serializable;

public class Address extends Field implements Serializable{

	private static final long serialVersionUID = 3859932508538553108L;

	private String type;
	private BaseField block;
	private BaseField building;
	private BaseField floor;
	private BaseField unit;
	private BaseField street;
	private BaseField postal;
	private BaseField line1;
	private BaseField line2;
	private FieldStatus country;
	
	public Address() {		
	}		
	
	public Address(String type, BaseField block, BaseField building, BaseField floor, BaseField unit, BaseField street,
			BaseField postal, BaseField line1, BaseField line2, FieldStatus country) {
		super();
		this.type = type;
		this.block = block;
		this.building = building;
		this.floor = floor;
		this.unit = unit;
		this.street = street;
		this.postal = postal;
		this.line1 = line1;
		this.line2 = line2;
		this.country = country;
	}

	public BaseField getLine1() {
		return line1;
	}

	public void setLine1(BaseField line1) {
		this.line1 = line1;
	}

	public BaseField getLine2() {
		return line2;
	}

	public void setLine2(BaseField line2) {
		this.line2 = line2;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BaseField getBlock() {
		return block;
	}
	public void setBlock(BaseField block) {
		this.block = block;
	}
	public BaseField getBuilding() {
		return building;
	}
	public void setBuilding(BaseField building) {
		this.building = building;
	}
	public BaseField getFloor() {
		return floor;
	}
	public void setFloor(BaseField floor) {
		this.floor = floor;
	}
	public BaseField getUnit() {
		return unit;
	}
	public void setUnit(BaseField unit) {
		this.unit = unit;
	}
	public BaseField getStreet() {
		return street;
	}
	public void setStreet(BaseField street) {
		this.street = street;
	}
	public BaseField getPostal() {
		return postal;
	}
	public void setPostal(BaseField postal) {
		this.postal = postal;
	}		
	
	public FieldStatus getCountry() {
		return country;
	}

	public void setCountry(FieldStatus country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [type=" + type + ", block=" + block + ", building=" + building + ", floor=" + floor + ", unit="
				+ unit + ", street=" + street + ", postal=" + postal + ", line1=" + line1 + ", line2=" + line2
				+ ", country=" + country + "]";
	}		
}

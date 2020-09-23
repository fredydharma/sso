package sg.nets.com.singpass.model;

import java.io.Serializable;

public class FieldStatus extends Field implements Serializable{
	
	private static final long serialVersionUID = -5844359614331937980L;
	
	private String code;
	private String desc;
	
	public FieldStatus() {		
	}
	
	public FieldStatus(String code, String desc,String lastupdated, String source, String classification, Object value, boolean unavailable) {
		super(lastupdated, source, classification, value, unavailable);	
		this.code = code;
		this.desc = desc;
	}		
	
	public FieldStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "VehicleStatus [code=" + code + ", desc=" + desc + "]";
	}		
}

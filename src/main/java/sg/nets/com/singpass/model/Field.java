package sg.nets.com.singpass.model;

import java.io.Serializable;

public class Field extends BaseField implements Serializable{

	private static final long serialVersionUID = -1288401807644335374L;
	private String lastupdated;
	private String source;
	private String classification;
	//private Object value;
	private boolean unavailable;

	public Field() {
	}		
	
	public Field(String lastupdated, String source, String classification, boolean unavailable) {
		this.lastupdated = lastupdated;
		this.source = source;
		this.classification = classification;
		this.unavailable = unavailable;
	}
	
	public Field(String lastupdated, String source, String classification, Object value, boolean unavailable) {
		super(value);
		this.lastupdated = lastupdated;
		this.source = source;
		this.classification = classification;		
		this.unavailable = unavailable;
	}
	
	public String getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	/*public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}*/
	
	public boolean isUnavailable() {
		return unavailable;
	}

	public void setUnavailable(boolean unavailable) {
		this.unavailable = unavailable;
	}

	@Override
	public String toString() {
		return "Field [lastupdated=" + lastupdated + ", source=" + source + ", classification=" + classification
				+ ", unavailable=" + unavailable + "]";
	}	
}

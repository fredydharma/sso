package sg.nets.com.singpass.model;

import java.io.Serializable;

public class BaseField implements Serializable{
	
	private static final long serialVersionUID = -5845838079765998949L;
	
	private Object value;
	
	public BaseField() {		
	}
		
	public BaseField(Object value) {		
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "BaseField [value=" + value + "]";
	}		
}

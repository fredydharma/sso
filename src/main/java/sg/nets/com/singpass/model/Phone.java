package sg.nets.com.singpass.model;

import java.io.Serializable;

public class Phone extends Field implements Serializable{

	private static final long serialVersionUID = -2162226140157572806L;

	private BaseField prefix;
	private BaseField areacode;
	private BaseField nbr;
	
	public Phone() {		
	}

	public Phone(BaseField prefix, BaseField areacode, BaseField nbr,boolean unavailable,
			String lastupdated, String source, String classification) {
		super(lastupdated, source, classification,unavailable);
		this.prefix = prefix;
		this.areacode = areacode;
		this.nbr = nbr;
	}

	public BaseField getPrefix() {
		return prefix;
	}

	public void setPrefix(BaseField prefix) {
		this.prefix = prefix;
	}

	public BaseField getAreacode() {
		return areacode;
	}

	public void setAreacode(BaseField areacode) {
		this.areacode = areacode;
	}

	public BaseField getNbr() {
		return nbr;
	}

	public void setNbr(BaseField nbr) {
		this.nbr = nbr;
	}

	@Override
	public String toString() {
		return "Phone [prefix=" + prefix + ", areacode=" + areacode + ", nbr=" + nbr + "]";
	}		
}

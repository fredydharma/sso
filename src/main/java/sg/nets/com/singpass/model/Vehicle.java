package sg.nets.com.singpass.model;

import java.io.Serializable;

public class Vehicle extends Field implements Serializable{

	private static final long serialVersionUID = -6540147421726150039L;
	
	private BaseField vehicleno;
	private BaseField type;
	private BaseField iulabelno;
	private BaseField make;
	private BaseField model;
	private BaseField chassisno;
	private BaseField engineno;
	private BaseField motorno;
	private BaseField yearofmanufacture;
	private BaseField firstregistrationdate;
	private BaseField originalregistrationdate;
	private BaseField coecategory;
	private BaseField coeexpirydate;
	private BaseField roadtaxexpirydate;
	private BaseField quotapremium;
	private BaseField openmarketvalue;
	private BaseField co2emission;
	private FieldStatus status;
	private BaseField primarycolour;
	private BaseField secondarycolour;
	private BaseField attachment1;
	private BaseField attachment2;
	private BaseField attachment3;
	private BaseField scheme;
	private BaseField thcemission;
	private BaseField coemission;
	private BaseField noxemission;
	private BaseField pmemission;
	private BaseField enginecapacity;
	private BaseField powerrate;
	private BaseField effectiveownership;
	private BaseField propellant;
	private BaseField maximumunladenweight;
	private BaseField maximumladenweight;
	private BaseField minimumparfbenefit;
	private BaseField nooftransfers;
	private BaseField vpc;		

	public Vehicle() {		
	}
	
	public Vehicle(BaseField vehicleno, BaseField type, BaseField iulabelno, BaseField make, BaseField model, BaseField chassisno,
			BaseField engineno, BaseField motorno, BaseField yearofmanufacture, BaseField firstregistrationdate,
			BaseField originalregistrationdate, BaseField coecategory, BaseField coeexpirydate, BaseField roadtaxexpirydate,
			BaseField quotapremium, BaseField openmarketvalue, BaseField co2emission, FieldStatus status, BaseField primarycolour,
			BaseField secondarycolour, BaseField attachment1, BaseField attachment2, BaseField attachment3, BaseField scheme,
			BaseField thcemission, BaseField coemission, BaseField noxemission, BaseField pmemission, BaseField enginecapacity,
			BaseField powerrate, BaseField effectiveownership, BaseField propellant, BaseField maximumunladenweight,
			BaseField maximumladenweight, BaseField minimumparfbenefit, BaseField nooftransfers, BaseField vpc, boolean unavailable,
			String lastupdated, String source, String classification) {
		super(lastupdated, source, classification,unavailable);
		this.vehicleno = vehicleno;
		this.type = type;
		this.iulabelno = iulabelno;
		this.make = make;
		this.model = model;
		this.chassisno = chassisno;
		this.engineno = engineno;
		this.motorno = motorno;
		this.yearofmanufacture = yearofmanufacture;
		this.firstregistrationdate = firstregistrationdate;
		this.originalregistrationdate = originalregistrationdate;
		this.coecategory = coecategory;
		this.coeexpirydate = coeexpirydate;
		this.roadtaxexpirydate = roadtaxexpirydate;
		this.quotapremium = quotapremium;
		this.openmarketvalue = openmarketvalue;
		this.co2emission = co2emission;
		this.status = status;
		this.primarycolour = primarycolour;
		this.secondarycolour = secondarycolour;
		this.attachment1 = attachment1;
		this.attachment2 = attachment2;
		this.attachment3 = attachment3;
		this.scheme = scheme;
		this.thcemission = thcemission;
		this.coemission = coemission;
		this.noxemission = noxemission;
		this.pmemission = pmemission;
		this.enginecapacity = enginecapacity;
		this.powerrate = powerrate;
		this.effectiveownership = effectiveownership;
		this.propellant = propellant;
		this.maximumunladenweight = maximumunladenweight;
		this.maximumladenweight = maximumladenweight;
		this.minimumparfbenefit = minimumparfbenefit;
		this.nooftransfers = nooftransfers;
		this.vpc = vpc;		
	}

	public BaseField getCo2emission() {
		return co2emission;
	}

	public void setCo2emission(BaseField co2emission) {
		this.co2emission = co2emission;
	}	
	
	public BaseField getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(BaseField vehicleno) {
		this.vehicleno = vehicleno;
	}
	public BaseField getType() {
		return type;
	}
	public void setType(BaseField type) {
		this.type = type;
	}
	public BaseField getIulabelno() {
		return iulabelno;
	}
	public void setIulabelno(BaseField iulabelno) {
		this.iulabelno = iulabelno;
	}
	public BaseField getMake() {
		return make;
	}
	public void setMake(BaseField make) {
		this.make = make;
	}
	public BaseField getModel() {
		return model;
	}
	public void setModel(BaseField model) {
		this.model = model;
	}
	public BaseField getChassisno() {
		return chassisno;
	}
	public void setChassisno(BaseField chassisno) {
		this.chassisno = chassisno;
	}
	public BaseField getEngineno() {
		return engineno;
	}
	public void setEngineno(BaseField engineno) {
		this.engineno = engineno;
	}
	public BaseField getMotorno() {
		return motorno;
	}
	public void setMotorno(BaseField motorno) {
		this.motorno = motorno;
	}
	public BaseField getYearofmanufacture() {
		return yearofmanufacture;
	}
	public void setYearofmanufacture(BaseField yearofmanufacture) {
		this.yearofmanufacture = yearofmanufacture;
	}
	public BaseField getFirstregistrationdate() {
		return firstregistrationdate;
	}
	public void setFirstregistrationdate(BaseField firstregistrationdate) {
		this.firstregistrationdate = firstregistrationdate;
	}
	public BaseField getOriginalregistrationdate() {
		return originalregistrationdate;
	}
	public void setOriginalregistrationdate(BaseField originalregistrationdate) {
		this.originalregistrationdate = originalregistrationdate;
	}
	public BaseField getCoecategory() {
		return coecategory;
	}
	public void setCoecategory(BaseField coecategory) {
		this.coecategory = coecategory;
	}
	public BaseField getCoeexpirydate() {
		return coeexpirydate;
	}
	public void setCoeexpirydate(BaseField coeexpirydate) {
		this.coeexpirydate = coeexpirydate;
	}
	public BaseField getRoadtaxexpirydate() {
		return roadtaxexpirydate;
	}
	public void setRoadtaxexpirydate(BaseField roadtaxexpirydate) {
		this.roadtaxexpirydate = roadtaxexpirydate;
	}
	public BaseField getQuotapremium() {
		return quotapremium;
	}
	public void setQuotapremium(BaseField quotapremium) {
		this.quotapremium = quotapremium;
	}
	public BaseField getOpenmarketvalue() {
		return openmarketvalue;
	}
	public void setOpenmarketvalue(BaseField openmarketvalue) {
		this.openmarketvalue = openmarketvalue;
	}
	public FieldStatus getStatus() {
		return status;
	}
	public void setStatus(FieldStatus status) {
		this.status = status;
	}
	public BaseField getPrimarycolour() {
		return primarycolour;
	}
	public void setPrimarycolour(BaseField primarycolour) {
		this.primarycolour = primarycolour;
	}
	public BaseField getSecondarycolour() {
		return secondarycolour;
	}
	public void setSecondarycolour(BaseField secondarycolour) {
		this.secondarycolour = secondarycolour;
	}
	public BaseField getAttachment1() {
		return attachment1;
	}
	public void setAttachment1(BaseField attachment1) {
		this.attachment1 = attachment1;
	}
	public BaseField getAttachment2() {
		return attachment2;
	}
	public void setAttachment2(BaseField attachment2) {
		this.attachment2 = attachment2;
	}
	public BaseField getAttachment3() {
		return attachment3;
	}
	public void setAttachment3(BaseField attachment3) {
		this.attachment3 = attachment3;
	}
	public BaseField getScheme() {
		return scheme;
	}
	public void setScheme(BaseField scheme) {
		this.scheme = scheme;
	}
	public BaseField getThcemission() {
		return thcemission;
	}
	public void setThcemission(BaseField thcemission) {
		this.thcemission = thcemission;
	}
	public BaseField getCoemission() {
		return coemission;
	}
	public void setCoemission(BaseField coemission) {
		this.coemission = coemission;
	}
	public BaseField getNoxemission() {
		return noxemission;
	}
	public void setNoxemission(BaseField noxemission) {
		this.noxemission = noxemission;
	}
	public BaseField getPmemission() {
		return pmemission;
	}
	public void setPmemission(BaseField pmemission) {
		this.pmemission = pmemission;
	}
	public BaseField getEnginecapacity() {
		return enginecapacity;
	}
	public void setEnginecapacity(BaseField enginecapacity) {
		this.enginecapacity = enginecapacity;
	}
	public BaseField getPowerrate() {
		return powerrate;
	}
	public void setPowerrate(BaseField powerrate) {
		this.powerrate = powerrate;
	}
	public BaseField getEffectiveownership() {
		return effectiveownership;
	}
	public void setEffectiveownership(BaseField effectiveownership) {
		this.effectiveownership = effectiveownership;
	}
	public BaseField getPropellant() {
		return propellant;
	}
	public void setPropellant(BaseField propellant) {
		this.propellant = propellant;
	}
	public BaseField getMaximumunladenweight() {
		return maximumunladenweight;
	}
	public void setMaximumunladenweight(BaseField maximumunladenweight) {
		this.maximumunladenweight = maximumunladenweight;
	}
	public BaseField getMaximumladenweight() {
		return maximumladenweight;
	}
	public void setMaximumladenweight(BaseField maximumladenweight) {
		this.maximumladenweight = maximumladenweight;
	}
	public BaseField getMinimumparfbenefit() {
		return minimumparfbenefit;
	}
	public void setMinimumparfbenefit(BaseField minimumparfbenefit) {
		this.minimumparfbenefit = minimumparfbenefit;
	}
	public BaseField getNooftransfers() {
		return nooftransfers;
	}
	public void setNooftransfers(BaseField nooftransfers) {
		this.nooftransfers = nooftransfers;
	}
	public BaseField getVpc() {
		return vpc;
	}
	public void setVpc(BaseField vpc) {
		this.vpc = vpc;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleno=" + vehicleno + ", type=" + type + ", iulabelno=" + iulabelno + ", make=" + make
				+ ", model=" + model + ", chassisno=" + chassisno + ", engineno=" + engineno + ", motorno=" + motorno
				+ ", yearofmanufacture=" + yearofmanufacture + ", firstregistrationdate=" + firstregistrationdate
				+ ", originalregistrationdate=" + originalregistrationdate + ", coecategory=" + coecategory
				+ ", coeexpirydate=" + coeexpirydate + ", roadtaxexpirydate=" + roadtaxexpirydate + ", quotapremium="
				+ quotapremium + ", openmarketvalue=" + openmarketvalue + ", co2emission=" + co2emission + ", status="
				+ status + ", primarycolour=" + primarycolour + ", secondarycolour=" + secondarycolour
				+ ", attachment1=" + attachment1 + ", attachment2=" + attachment2 + ", attachment3=" + attachment3
				+ ", scheme=" + scheme + ", thcemission=" + thcemission + ", coemission=" + coemission
				+ ", noxemission=" + noxemission + ", pmemission=" + pmemission + ", enginecapacity=" + enginecapacity
				+ ", powerrate=" + powerrate + ", effectiveownership=" + effectiveownership + ", propellant="
				+ propellant + ", maximumunladenweight=" + maximumunladenweight + ", maximumladenweight="
				+ maximumladenweight + ", minimumparfbenefit=" + minimumparfbenefit + ", nooftransfers=" + nooftransfers
				+ ", vpc=" + vpc + "]";
	}		
}

package com.mms.api.unitconversion.model;

/**
 * @author snehal.bachchhav
 * POJO:Unit Conversion Factor 
 *
 */
public class UnitConversionFactor {

	private String id;
	private String type;
	private String conversion_factor;
	private String to_unit;
	private String from_unit;

	public UnitConversionFactor() {
		super();
	}

	public UnitConversionFactor(String id, String type, String conversion_factor, String to_unit, String from_unit) {
		super();
		this.id = id;
		this.type = type;
		this.conversion_factor = conversion_factor;
		this.to_unit = to_unit;
		this.from_unit = from_unit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConversion_factor() {
		return conversion_factor;
	}

	public void setConversion_factor(String conversion_factor) {
		this.conversion_factor = conversion_factor;
	}

	public String getTo_unit() {
		return to_unit;
	}

	public void setTo_unit(String to_unit) {
		this.to_unit = to_unit;
	}

	public String getFrom_unit() {
		return from_unit;
	}

	public void setFrom_unit(String from_unit) {
		this.from_unit = from_unit;
	}

}

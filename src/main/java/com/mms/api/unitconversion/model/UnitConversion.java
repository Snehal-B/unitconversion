package com.mms.api.unitconversion.model;

/**
 * @author snehal.bachchhav
 * POJO: Unit Conversion
 */
public class UnitConversion {

	String originalUnit;
	String originalValue;
	String convertedValue;
	String convertedUnit;

	public UnitConversion(String originalUnit, String originalValue, String convertedValue, String convertedUnit) {
		super();
		this.originalUnit = originalUnit;
		this.originalValue = originalValue;
		this.convertedValue = convertedValue;
		this.convertedUnit = convertedUnit;
	}
	
	
	public UnitConversion() {
		super();
	}


	public String getOriginalUnit() {
		return originalUnit;
	}
	public void setOriginalUnit(String originalUnit) {
		this.originalUnit = originalUnit;
	}
	public String getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(String originalValue) {
		this.originalValue = originalValue;
	}
	public String getConvertedValue() {
		return convertedValue;
	}
	public void setConvertedValue(String convertedValue) {
		this.convertedValue = convertedValue;
	}
	public String getConvertedUnit() {
		return convertedUnit;
	}
	public void setConvertedUnit(String convertedUnit) {
		this.convertedUnit = convertedUnit;
	}	
	
	


}

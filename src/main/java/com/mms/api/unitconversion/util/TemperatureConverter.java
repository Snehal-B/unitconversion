package com.mms.api.unitconversion.util;

import java.math.BigDecimal;

/**
 * @author snehal.bachchhav
 * Utility class  to convert Temperature values from celsius,fahrenheit and kelvin
 *
 */
public class TemperatureConverter {

	public static BigDecimal convertTemperature(BigDecimal value, String fromUnit, String toUnit,
			BigDecimal conversionFactor) {
		BigDecimal convertedValue;
		switch (fromUnit.toLowerCase()) {
		case "celsius":
			convertedValue = convertFromCelsius(value, toUnit, conversionFactor);
			break;
		case "fahrenheit":
			convertedValue = convertFromFahrenheit(value, toUnit, conversionFactor);
			break;
		case "kelvin":
			convertedValue = convertFromKelvin(value, toUnit, conversionFactor);
			break;
		default:
			throw new IllegalArgumentException("Unsupported fromUnit: " + fromUnit);
		}

		return convertedValue;
	}

	private static BigDecimal convertFromCelsius(BigDecimal value, String toUnit, BigDecimal conversionFactor) {
		switch (toUnit.toLowerCase()) {
		case "celsius":
			return value;
		case "fahrenheit":
			return ((conversionFactor.multiply(value)).add(BigDecimal.valueOf(32)));
		case "kelvin":
			return BigDecimal.valueOf(273.15).add(value);
		default:
			throw new IllegalArgumentException("Unsupported toUnit: " + toUnit);
		}
	}

	private static BigDecimal convertFromFahrenheit(BigDecimal value, String toUnit, BigDecimal conversionFactor) {
		switch (toUnit.toLowerCase()) {
		case "celsius":
			return (value.subtract(BigDecimal.valueOf(32))).multiply(conversionFactor);
		case "fahrenheit":
			return value;
		case "kelvin":
			return (value.add(BigDecimal.valueOf(459.67))).multiply(conversionFactor);
		default:
			throw new IllegalArgumentException("Unsupported toUnit: " + toUnit);
		}
	}

	private static BigDecimal convertFromKelvin(BigDecimal value, String toUnit, BigDecimal conversionFactor) {
		switch (toUnit.toLowerCase()) {
		case "celsius":
			return value.subtract(BigDecimal.valueOf(273.15));
		case "fahrenheit":
			return (value.multiply(conversionFactor)).subtract(BigDecimal.valueOf(459.67));
		case "kelvin":
			return value;
		default:
			throw new IllegalArgumentException("Unsupported toUnit: " + toUnit);
		}
	}

//    public static void main(String[] args) {
//        TemperatureConverter converter = new TemperatureConverter();
//
//        double value = 0;
//        String fromUnit = "celsius";
//        String toUnit = "fahrenheit";
//
//        BigDecimal convertedValue = converter.convertTemperature(value, fromUnit, toUnit,conversionFactor);
//        System.out.println(value + " " + fromUnit + " is equal to " + convertedValue + " " + toUnit);
//    }
}

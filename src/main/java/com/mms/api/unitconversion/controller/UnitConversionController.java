package com.mms.api.unitconversion.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.api.unitconversion.model.UnitConversion;
import com.mms.api.unitconversion.model.UnitConversionFactor;
import com.mms.api.unitconversion.service.UnitConversionFactorProxy;
import com.mms.api.unitconversion.util.TemperatureConverter;
import com.mms.api.unitconversion.util.UnitType;

/**
 * @author snehal.bachchhav
 *
 */
@RestController
@RequestMapping(path = "/mms.com", produces = { "application/json", "text/xml" })
@EnableAutoConfiguration
public class UnitConversionController {

	@Autowired
	private UnitConversionFactorProxy proxy;

	private static final Logger logger = LoggerFactory.getLogger(UnitConversionController.class);

	@GetMapping("/unit-conversion/{from}/{to}/{quantity}")
	public UnitConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		UnitConversion unitConversion = new UnitConversion();
		UnitConversionFactor unitConversionFactor;
		BigDecimal convertedValue = BigDecimal.ZERO;
		logger.info("convert " + quantity.toString() + " Quantities From " + from + " to ");
		try {
			unitConversionFactor = invokeExternalService(from, to);
		} catch (Exception e) {
			throw e;
		}
		BigDecimal conversionFactor = unitConversionFactor == null ? BigDecimal.ONE
				: BigDecimal.valueOf(Double.valueOf(unitConversionFactor.getConversion_factor()));

		unitConversion.setOriginalUnit(from);
		unitConversion.setOriginalValue(quantity.toString());
		unitConversion.setConvertedUnit(to);
		if (UnitType.TEMPERATURE.toString().equals(unitConversionFactor.getType())) {
			convertedValue = TemperatureConverter.convertTemperature(quantity, from, to, conversionFactor);
		} else {
			convertedValue = quantity.multiply(conversionFactor);
		}
		unitConversion.setConvertedValue(convertedValue.toString());

		return unitConversion;

	}

	/**
	 * Method to fetch Conversion Factor by  calling another service 
	 * @param from
	 * @param to
	 * @return UnitConversionFactor
	 * @throws IllegalArgumentException
	 */
	private UnitConversionFactor invokeExternalService(String from, String to) throws IllegalArgumentException {
		UnitConversionFactor unitConversionFactor;
		try {
			unitConversionFactor = proxy.getUnitConversionByFromToUnit(from, to);
			logger.info("Received response from conversionfactor Service");
		} catch (Exception e) {
			logger.error("Error fetching Unit Conversion Factor " + e);
			throw new RuntimeException("Error fetching Unit Conversion Factor for from " + from + " to " + to, e);
		}
		return unitConversionFactor;

	}

}

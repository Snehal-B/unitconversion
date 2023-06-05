package com.mms.api.unitconversion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.mms.api.unitconversion.model.UnitConversionFactor;

/**
 * @author snehal.bachchhav
 *
 */
@FeignClient(name = "unit-conversion-factor", url = "http://localhost:8081/conversionfactor")
public interface UnitConversionFactorProxy {

	@GetMapping("/{from}/{to}")
	public UnitConversionFactor getUnitConversionByFromToUnit(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
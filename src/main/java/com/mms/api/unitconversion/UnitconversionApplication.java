package com.mms.api.unitconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author snehal.bachchhav
 *
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.mms.api.unitconversion.service"})
public class UnitconversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitconversionApplication.class, args);
	}

}

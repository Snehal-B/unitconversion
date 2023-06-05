package com.mms.api.unitconversion;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
	
	@SpringBootTest
	@AutoConfigureMockMvc
	public class UnitconversionApplicationTests {

	    @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void testConvertCelsiusToFahrenheit() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/mms.com/unit-conversion/{originalUnit}/{convertedUnit}/{quantity}","celsius","fahrenheit", 1))
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.originalValue").value(1))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.convertedValue").value(33.8))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.originalUnit").value("celsius"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.convertedUnit").value("fahrenheit"));
	    }
	    
	    @Test
	    public void testConvertMetricToImperial() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/mms.com/unit-conversion/{originalUnit}/{convertedUnit}/{quantity}","meters","feet", 20))
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.originalValue").value(20))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.convertedValue").value(65.60))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.originalUnit").value("meters"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.convertedUnit").value("feet"));
	    }

	}


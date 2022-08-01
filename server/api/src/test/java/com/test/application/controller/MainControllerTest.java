package com.test.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.test.application.services.CovidService;

// Test class for Main REST controller
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MainController.class)
@ActiveProfiles({"test"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MainControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
    
	@MockBean
	CovidService covidService;
	
    @Test
    void ensureServiceResponds() throws Exception {
    	RequestBuilder builder = MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_PLAIN);
    	MvcResult result = mockMvc.perform(builder).andReturn();
    	
    	String expected = "Hello World! Welcome to Lunatech Covid Assessment";
    	
    	assertEquals(expected, result.getResponse().getContentAsString());
    }
    
    @Test
    void ensureQueryServiceResponds() throws Exception {
    	RequestBuilder builder = MockMvcRequestBuilders.get("/queryInfecDeaths?name=germany&date=2020-05-01").accept(MediaType.APPLICATION_JSON);
    	MvcResult result = mockMvc.perform(builder).andReturn();
    	
    	assertNotEquals(result.getResponse(), null);
    }
    
    @Test
    void ensureVaccinationReportServiceResponds() throws Exception {
    	RequestBuilder builder = MockMvcRequestBuilders.get("/getHighestLowestVaccinations").accept(MediaType.APPLICATION_JSON);
    	MvcResult result = mockMvc.perform(builder).andReturn();
    	
    	assertNotEquals(result.getResponse(), null);
    }
    
    @Test
    void ensureInfectionReportServiceResponds() throws Exception {
    	RequestBuilder builder = MockMvcRequestBuilders.get("/getHighestInfections").accept(MediaType.APPLICATION_JSON);
    	MvcResult result = mockMvc.perform(builder).andReturn();
    	
    	assertNotEquals(result.getResponse(), null);
    }
    
    @Test
    void ensureUnVaccinatedReportServiceResponds() throws Exception {
    	RequestBuilder builder = MockMvcRequestBuilders.get("/getUnVaccinatedCountries").accept(MediaType.APPLICATION_JSON);
    	MvcResult result = mockMvc.perform(builder).andReturn();
    	
    	assertNotEquals(result.getResponse(), null);
    }
    
}

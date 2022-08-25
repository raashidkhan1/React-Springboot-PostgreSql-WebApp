package com.test.application.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.application.services.CovidService;

//Controller class provides endpoints for rest services
@CrossOrigin
@RestController
public class MainController {

	@Autowired
	CovidService covidService;
	
	// Hello Service for local tests ** not mapped with frontend
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String hello() {
        return "Hello World! Welcome to Lunatech Covid Assessment";
    }
    
    // Query service for infections and deaths
    @RequestMapping(value = "/queryInfecDeaths", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> getInfectionsandDeaths(
    		@RequestParam("name") String countryName, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") String date){
    	return new ResponseEntity<Object>(covidService.findByCountryAndDate(countryName, date), HttpStatus.OK);
    }
    
    // Reporting service for top 10 countries with highest/lowest vaccinations
    @RequestMapping(value = "/getHighestLowestVaccinations", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> getHighestLowestVaccinations(){
    	return new ResponseEntity<Object>(covidService.getHighestLowestVaccinations(), HttpStatus.OK);
    }
    
    // Reporting service for top 10 countries with highest infections
    @RequestMapping(value = "/getHighestInfections", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> getHighestInfections(){
    	return new ResponseEntity<Object>(covidService.getHighestInfections(), HttpStatus.OK);
    }
    
    // Reporting service for unvaccinated countries
    @RequestMapping(value = "/getUnVaccinatedCountries", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> getUnvaccinatedCountries(){
    	return new ResponseEntity<Object>(covidService.getUnvaccinatedCountries(), HttpStatus.OK);
    }
    
    
}
package com.test.application.services;

import java.util.List;

import com.test.application.models.HighestLowestVaccinations;
import com.test.application.models.InfectionReportRow;
import com.test.application.models.QueryRow;

// An interface for services
public interface CovidService {

	List<QueryRow> findByCountryAndDate(String country, String date);
	
	HighestLowestVaccinations getHighestLowestVaccinations();
	
	List<InfectionReportRow> getHighestInfections();
	
	List<String> getUnvaccinatedCountries();
	
}

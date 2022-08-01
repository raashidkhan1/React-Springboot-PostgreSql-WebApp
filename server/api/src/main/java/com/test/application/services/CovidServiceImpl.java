package com.test.application.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.application.models.HighestLowestVaccinations;
import com.test.application.models.InfectionReportRow;
import com.test.application.models.QueryRow;
import com.test.application.models.ReportRow;
import com.test.application.repository.QueryRepository;

// This class serves as a implementation of CovidService interface
@Service
public class CovidServiceImpl implements CovidService {
	
	private static final int LIMIT = 10;
	
	@Autowired
	QueryRepository qRepository;
	
	
	@Override
	public List<QueryRow> findByCountryAndDate(String country, String date) {
		
		return qRepository.findByCountryNameAndDate(country, date);
	}

	@Override
	public HighestLowestVaccinations getHighestLowestVaccinations() {
		List<ReportRow> highest = qRepository.getHighestVaccinations(LIMIT);
		List<ReportRow> lowest = qRepository.getLowestVaccinations(LIMIT);
		
		return new HighestLowestVaccinations(highest, lowest);
	}

	@Override
	public List<InfectionReportRow> getHighestInfections() {
		return qRepository.getHighestInfections(LIMIT);
	}

	@Override
	public List<String> getUnvaccinatedCountries() {
		return qRepository.getCountriesWithNoVaccinations();
	}
	
	
	
}

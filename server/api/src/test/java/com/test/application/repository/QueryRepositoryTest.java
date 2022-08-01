package com.test.application.repository;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class QueryRepositoryTest {
	
	@Autowired
	QueryRepository queryRepository;
	
	
	@Test
	public void correctInit() {
		assertNotNull(queryRepository);
	}
	
	@Test
	public void findByName() {
		assertNotNull(queryRepository.findByName("Germany"));
	}
	
	@Test
	public void testQueryData() {
		assertNotNull(queryRepository.findByCountryNameAndDate("Zimbabwe", "2020-02-02"));
	}
	
	@Test
	public void testFuzzyQueryData() {
		assertNotNull(queryRepository.findByCountryNameAndDate("Zimb", "2020-02-02"));
	}
	
	@Test
	public void testFuzzyQueryData2() {
		assertTrue(queryRepository.findByCountryNameAndDate("Zimb", "2020-10-01").size()>0);
	}
	
	@Test
	public void testFuzzyQueryData3() {
		assertTrue(queryRepository.findByCountryNameAndDate("randomvaluenooneknows", "2020-02-02").size()==0);
	}
	
	@Test
	public void testVaccinationQuery() {
		assertNotNull(queryRepository.getHighestVaccinations(10));
		assertNotNull(queryRepository.getLowestVaccinations(10));
	}
	
	@Test
	public void testVaccinationQuery2() {
		assertNotNull(queryRepository.getHighestVaccinations(1));
		assertNotNull(queryRepository.getLowestVaccinations(1));
		assertTrue(queryRepository.getHighestVaccinations(1).size()==1);
		assertTrue(queryRepository.getLowestVaccinations(1).size()==1);
	}
	
	@Test
	public void testVaccinationQuery3() {
		assertNotNull(queryRepository.getHighestVaccinations(1));
		assertNotNull(queryRepository.getLowestVaccinations(1));
		assertTrue(queryRepository.getHighestVaccinations(0).size()==0);
		assertTrue(queryRepository.getLowestVaccinations(0).size()==0);
	}
	
	@Test
	public void testInfectionsQuery(){
		assertNotNull(queryRepository.getHighestInfections(10));
	}
	
	@Test
	public void testUnVaccinatedQuery() {
		assertNotNull(queryRepository.getCountriesWithNoVaccinations());
	}
	
	

}

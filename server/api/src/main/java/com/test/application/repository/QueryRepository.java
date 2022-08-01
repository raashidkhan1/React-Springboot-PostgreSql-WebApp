package com.test.application.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.application.entities.Countries;
import com.test.application.models.InfectionReportRow;
import com.test.application.models.QueryRow;
import com.test.application.models.ReportRow;

// A JPA repository to fetch data from the database
@Repository
public interface QueryRepository extends JpaRepository<Countries, Long> {
	
	Optional<Countries> findByName(String name);
	
	
	@Query(value = "SELECT ca.infections, ca.deaths, ca.recorded_date FROM cases ca INNER JOIN countries co "
			+ "ON ca.iso_country = co.code "
			+ "WHERE LOWER(co.name) LIKE LOWER(CONCAT(?1, '%')) AND ca.recorded_date\\:\\:text <= ?2 ", nativeQuery = true)
	List<QueryRow> findByCountryNameAndDate(String name, String date);
	
	@Query(value = "SELECT SUM(va.daily_vaccinations) AS total, co.name FROM "
			+ "vaccinations va INNER JOIN countries co ON va.iso_country=co.code "
			+ "GROUP BY co.name ORDER BY total DESC LIMIT ?1 ", nativeQuery = true)
	List<ReportRow> getHighestVaccinations(int count);
	
	@Query(value = "SELECT SUM(va.daily_vaccinations) AS total, co.name FROM "
			+ "vaccinations va INNER JOIN countries co ON va.iso_country=co.code "
			+ "GROUP BY co.name ORDER BY total ASC LIMIT ?1", nativeQuery = true)
	List<ReportRow> getLowestVaccinations(int count);
	
	@Query(value = "SELECT SUM(ca.infections) AS total, co.name FROM cases ca INNER JOIN countries co"
			+ " ON ca.iso_country=co.code \n"
			+ "GROUP BY co.population, co.name ORDER BY SUM(ca.infections)/100000 DESC LIMIT ?1", nativeQuery = true)
	List<InfectionReportRow> getHighestInfections(int count);
	
	@Query(value="SELECT * FROM "
			+ "(SELECT co.name, SUM(va.daily_vaccinations_raw) AS total FROM countries co INNER JOIN vaccinations va ON co.code=va.iso_country "
			+ "GROUP BY co.name) c WHERE c.total = 0", nativeQuery = true)
	List<String> getCountriesWithNoVaccinations();
	
}

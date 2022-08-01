package com.test.application.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vaccinations")
public class Vaccinations {

	@EmbeddedId
	private VaccinationId vaccinationId;
	
	@Column(name = "daily_vaccinations_raw")
	public Long dailyVaccinationsRaw;
	
	@Column(name = "daily_vaccinations")
	public Long dailyVaccinations;
	
	public Vaccinations() {
		super();
	}

	public Vaccinations(VaccinationId vaccinationId, Long dailyVaccinationsRaw, Long dailyVaccinations) {
		this.vaccinationId = vaccinationId;
		this.dailyVaccinationsRaw = dailyVaccinationsRaw;
		this.dailyVaccinations = dailyVaccinations;
	}

	public VaccinationId getVaccinationId() {
		return vaccinationId;
	}

	public void setVaccinationId(VaccinationId vaccinationId) {
		this.vaccinationId = vaccinationId;
	}

	public Long getDailyVaccinationsRaw() {
		return dailyVaccinationsRaw;
	}

	public void setDailyVaccinationsRaw(Long dailyVaccinationsRaw) {
		this.dailyVaccinationsRaw = dailyVaccinationsRaw;
	}

	public Long getDailyVaccinations() {
		return dailyVaccinations;
	}

	public void setDailyVaccinations(Long dailyVaccinations) {
		this.dailyVaccinations = dailyVaccinations;
	}
	

}

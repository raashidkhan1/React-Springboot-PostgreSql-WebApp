package com.test.application.entities;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cases")
public class Cases {

	@EmbeddedId
	private CasesId casesId;
	
	@Column(name = "infections", nullable = false)
	private Long infections;
	
	@Column(name = "deaths", nullable = false)
	private Long deaths;
	
	public Cases() {
		super();
	}

	public Cases(CasesId casesId, Long infections, Long deaths) {
		this.casesId = casesId;
		this.infections = infections;
		this.deaths = deaths;
	}

	public CasesId getCasesId() {
		return casesId;
	}

	public void setCasesId(CasesId casesId) {
		this.casesId = casesId;
	}

	public Long getInfections() {
		return infections;
	}

	public void setInfections(Long infections) {
		this.infections = infections;
	}

	public Long getDeaths() {
		return deaths;
	}

	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}
	
}

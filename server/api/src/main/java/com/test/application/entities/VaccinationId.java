package com.test.application.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class VaccinationId implements Serializable {

	
	private static final long serialVersionUID = 2246595919255249864L;


	@Column(name = "recorded_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date recordedDate;
	
	
	@ManyToOne
	@JoinColumn(name = "iso_country", referencedColumnName = "code")
	public Countries country;


	public VaccinationId(Date recordedDate, Countries country) {
		this.recordedDate = recordedDate;
		this.country = country;
	}


	public Date getRecordedDate() {
		return recordedDate;
	}


	public void setRecordedDate(Date recordedDate) {
		this.recordedDate = recordedDate;
	}


	public Countries getCountry() {
		return country;
	}


	public void setCountry(Countries country) {
		this.country = country;
	}
	
}

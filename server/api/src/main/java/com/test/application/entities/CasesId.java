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
public class CasesId implements Serializable {
	
	private static final long serialVersionUID = -4101683214574897121L;

	@Column(name = "recorded_date",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date recordedDate;
	
	
	@ManyToOne
	@JoinColumn(name = "iso_country", referencedColumnName = "code")
	public Countries country;


	public CasesId(Date recordedDate, Countries country) {
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

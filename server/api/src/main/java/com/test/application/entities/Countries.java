package com.test.application.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * @author raashid
 *
 */

@Entity
@Table(name = "countries", uniqueConstraints = {@UniqueConstraint(columnNames = {"code", "name"})})
public class Countries {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "population", nullable = false)
	private Long population;
	
	@Column(name = "continent", nullable = false)
	private String continent;
	
	@Column(name = "wikipedia_link")
	private String wikipediaLink;
	
	@Column(name = "keywords")
	private String keywords;
	
	public Countries() {
		super();
	}

	public Countries(Long id, String code, String name, String continent) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.continent = continent;
	}

	public Countries(Long id, String code, String name, Long population, String continent, String wikipediaLink,
			String keywords) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.population = population;
		this.continent = continent;
		this.wikipediaLink = wikipediaLink;
		this.keywords = keywords;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getWikipediaLink() {
		return wikipediaLink;
	}

	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	  @Override
	  public String toString() {
	    return "Country{" +
	        "id=" + id +
	        ", code='" + code + '\'' +
	        ", name='" + name + '\'' +
	        '}';
	  }
}

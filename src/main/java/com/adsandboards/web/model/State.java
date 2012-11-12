package com.adsandboards.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tblState")
public class State extends BaseModel {

	private String stateName;
	private Country country;

	public State() {
	}

	public State(String stateName, Country country) {
		this.stateName = stateName;
		this.country = country;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stateId")
	public Long getId() {
		return super.getId();
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@ManyToOne
	@JoinColumn(name = "countryId")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}

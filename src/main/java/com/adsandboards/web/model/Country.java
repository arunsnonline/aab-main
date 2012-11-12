package com.adsandboards.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tblCountry")
public class Country extends BaseModel {

	private String countryCode;
	private String countryName;

	public Country() {
	}

	public Country(String countryCode, String countryName) {
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "countryId")
	public Long getId() {
		return super.getId();
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}

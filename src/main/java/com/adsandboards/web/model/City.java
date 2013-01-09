package com.adsandboards.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tblCity")
public class City extends BaseModel {

	private String cityName;
	private State state;

	public City() {
		// Empty Constructor
	}

	public City(String cityName, State state) {
		this.cityName = cityName;
		this.state = state;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cityId")
	public Long getId() {
		return super.getId();
	}

	@ManyToOne
	@JoinColumn(name = "stateId")
	public State getState() {
		if (state == null) {
			state = new State();
		}
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}

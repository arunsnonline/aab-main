package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.CityDao;
import com.adsandboards.web.model.City;
import com.adsandboards.web.model.State;

public class CityDaoImpl extends GenericDaoImpl<City, Long> implements CityDao {

	static final Logger logger = Logger.getLogger(CityDaoImpl.class);

	public CityDaoImpl() {
		super(City.class);
	}

	@Override
	public City save(City city) {
		logger.debug("******************:" + city.getState().getId());
		State state = entityManager.find(State.class, city.getState().getId());
		city.setState(state);
		return entityManager.merge(city);
	}

}

package com.adsandboards.web.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.CityDao;
import com.adsandboards.web.model.City;
import com.adsandboards.web.model.State;
import com.adsandboards.web.util.QueryUtil;

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

	@Override
	public List<City> getCityListStartsWithName(String cityNameStartsWith,
			Long stateId) {
		List<City> list = QueryUtil
				.listAndCast(this.entityManager
						.createQuery(
								"select p from "
										+ City.class.getName()
										+ " p where p.cityName like :cityName and p.state.id=:stateId")
						.setParameter("cityName", cityNameStartsWith + "%")
						.setParameter("stateId", stateId));
		return list;
	}

}

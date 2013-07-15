package com.adsandboards.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.CityDao;
import com.adsandboards.web.model.City;
import com.adsandboards.web.service.CityService;

public class CityServiceImpl extends GenericServiceImpl<City, Long> implements
		CityService {

	private CityDao cityDao;

	@Autowired
	public CityServiceImpl(CityDao cityDao) {
		super(cityDao);
		this.cityDao = cityDao;
	}

	@Override
	public List<City> getCityListStartsWithName(String cityNameStartsWith,
			Long stateId) {
		return this.cityDao.getCityListStartsWithName(cityNameStartsWith,
				stateId);
	}
}

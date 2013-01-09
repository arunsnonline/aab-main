package com.adsandboards.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.CityDao;
import com.adsandboards.web.model.City;
import com.adsandboards.web.service.CityService;

public class CityServiceImpl extends GenericServiceImpl<City, Long> implements
		CityService {

	@Autowired
	public CityServiceImpl(CityDao cityDao) {
		super(cityDao);
	}
}

package com.adsandboards.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.CountryDao;
import com.adsandboards.web.model.Country;
import com.adsandboards.web.service.CountryService;

public class CountryServiceImpl extends GenericServiceImpl<Country, Long>
		implements CountryService {

	private CountryDao countryDao;

	@Autowired
	public CountryServiceImpl(CountryDao countryDao) {
		super(countryDao);
		this.countryDao = countryDao;
	}

	@Override
	public List<Country> getCountryListStartsWithName(String countryName) {
		return this.countryDao.getCountryListStartsWithName(countryName);
	}
}

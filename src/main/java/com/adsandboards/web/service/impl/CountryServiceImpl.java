package com.adsandboards.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.CountryDao;
import com.adsandboards.web.model.Country;
import com.adsandboards.web.service.CountryService;

public class CountryServiceImpl extends GenericServiceImpl<Country, Long>
		implements CountryService {

	@Autowired
	public CountryServiceImpl(CountryDao countryDao) {
		super(countryDao);
	}
}

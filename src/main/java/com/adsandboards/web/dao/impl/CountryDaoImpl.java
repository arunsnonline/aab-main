package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.CountryDao;
import com.adsandboards.web.model.Country;

public class CountryDaoImpl extends GenericDaoImpl<Country, Long> implements
		CountryDao {

	static final Logger logger = Logger.getLogger(CountryDaoImpl.class);

	public CountryDaoImpl() {
		super(Country.class);
	}

}

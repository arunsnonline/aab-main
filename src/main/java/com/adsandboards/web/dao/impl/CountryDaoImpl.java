package com.adsandboards.web.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.CountryDao;
import com.adsandboards.web.model.Country;
import com.adsandboards.web.util.QueryUtil;

public class CountryDaoImpl extends GenericDaoImpl<Country, Long> implements
		CountryDao {

	static final Logger logger = Logger.getLogger(CountryDaoImpl.class);

	public CountryDaoImpl() {
		super(Country.class);
	}

	@Override
	public List<Country> getCountryListStartsWithName(String countryName) {
		List<Country> list = QueryUtil.listAndCast(this.entityManager
				.createQuery(
						"select p from " + Country.class.getName()
								+ " p where p.countryName like :countryName")
				.setParameter("countryName", countryName + "%"));
		return list;
	}

}

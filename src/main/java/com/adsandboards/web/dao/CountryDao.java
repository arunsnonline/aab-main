package com.adsandboards.web.dao;

import java.util.List;

import com.adsandboards.web.model.Country;

public interface CountryDao extends GenericDao<Country, Long> {

	public List<Country> getCountryListStartsWithName(String countryName);

}

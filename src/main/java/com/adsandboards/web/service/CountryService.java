package com.adsandboards.web.service;

import java.util.List;

import com.adsandboards.web.model.Country;

public interface CountryService extends GenericService<Country, Long> {

	public List<Country> getCountryListStartsWithName(String countryName);

}

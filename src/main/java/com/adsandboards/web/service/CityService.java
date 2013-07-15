package com.adsandboards.web.service;

import java.util.List;

import com.adsandboards.web.model.City;

public interface CityService extends GenericService<City, Long> {

	List<City> getCityListStartsWithName(String cityNameStartsWith, Long stateId);

}

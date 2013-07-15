package com.adsandboards.web.dao;

import java.util.List;

import com.adsandboards.web.model.City;

public interface CityDao extends GenericDao<City, Long> {

	List<City> getCityListStartsWithName(String cityNameStartsWith, Long stateId);

}

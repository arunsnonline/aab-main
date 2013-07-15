package com.adsandboards.web.dao;

import java.util.List;

import com.adsandboards.web.model.State;

public interface StateDao extends GenericDao<State, Long> {

	List<State> getStateListStartsWithName(String stateNameStartsWith,
			Long countryId);

}

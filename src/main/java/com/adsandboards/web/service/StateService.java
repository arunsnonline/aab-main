package com.adsandboards.web.service;

import java.util.List;

import com.adsandboards.web.model.State;

public interface StateService extends GenericService<State, Long> {

	List<State> getStateListStartsWithName(String stateNameStartsWith,
			Long countryId);

}

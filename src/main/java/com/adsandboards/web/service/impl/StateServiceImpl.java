package com.adsandboards.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.StateDao;
import com.adsandboards.web.model.State;
import com.adsandboards.web.service.StateService;

public class StateServiceImpl extends GenericServiceImpl<State, Long> implements
		StateService {

	private StateDao stateDao;

	@Autowired
	public StateServiceImpl(StateDao stateDao) {
		super(stateDao);
		this.stateDao = stateDao;
	}

	@Override
	public List<State> getStateListStartsWithName(String stateNameStartsWith,
			Long countryId) {
		return this.stateDao.getStateListStartsWithName(stateNameStartsWith,
				countryId);
	}
}

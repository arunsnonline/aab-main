package com.adsandboards.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.StateDao;
import com.adsandboards.web.model.State;
import com.adsandboards.web.service.StateService;

public class StateServiceImpl extends GenericServiceImpl<State, Long> implements
		StateService {

	@Autowired
	public StateServiceImpl(StateDao stateDao) {
		super(stateDao);
	}
}

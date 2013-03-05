package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.StateDao;
import com.adsandboards.web.model.Country;
import com.adsandboards.web.model.State;

public class StateDaoImpl extends GenericDaoImpl<State, Long> implements
		StateDao {

	static final Logger logger = Logger.getLogger(StateDaoImpl.class);

	public StateDaoImpl() {
		super(State.class);
	}

	@Override
	public State save(State state) {
		logger.debug("******************:" + state.getCountry().getId());
		Country country = entityManager.find(Country.class, state.getCountry()
				.getId());
		state.setCountry(country);
		return entityManager.merge(state);
	}

}

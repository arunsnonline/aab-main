package com.adsandboards.web.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.StateDao;
import com.adsandboards.web.model.Country;
import com.adsandboards.web.model.State;
import com.adsandboards.web.util.QueryUtil;

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

	@Override
	public List<State> getStateListStartsWithName(String stateNameStartsWith,
			Long countryId) {
		List<State> list = QueryUtil
				.listAndCast(this.entityManager
						.createQuery(
								"select p from "
										+ State.class.getName()
										+ " p where p.stateName like :stateName and p.country.id=:countryId")
						.setParameter("stateName", stateNameStartsWith + "%")
						.setParameter("countryId", countryId));
		return list;
	}

}

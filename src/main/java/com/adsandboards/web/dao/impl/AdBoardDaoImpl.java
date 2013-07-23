package com.adsandboards.web.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.AdBoardDao;
import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.util.QueryUtil;

public class AdBoardDaoImpl extends GenericDaoImpl<AdBoard, Long> implements
		AdBoardDao {

	static final Logger logger = Logger.getLogger(AdBoardDaoImpl.class);

	public AdBoardDaoImpl() {
		super(AdBoard.class);
	}

	@Override
	public List<AdBoard> getAllBoardsForCriteria(AdBoard adBoard) {
		Long cityId = adBoard.getCity() != null ? adBoard.getCity().getId()
				: null;
		List<AdBoard> adBoards = null;
		String detailedLocationQuery = adBoard.getDetailedLocation() != null ? " and u.detailedLocation like %"
				+ adBoard.getDetailedLocation() + "%"
				: "";
		if (cityId != null) {
			adBoards = QueryUtil.listAndCast(this.entityManager.createQuery(
					"select u from " + AdBoard.class.getName()
							+ " u where u.city.id=:cityId"
							+ detailedLocationQuery).setParameter("cityId",
					cityId));
		}
		return adBoards;
	}

	@Override
	public List<String> getSimilarLandmarkList(Long cityId, String street) {
		List<String> list = QueryUtil
				.listAndCast(this.entityManager
						.createQuery(
								"select p.street from "
										+ AdBoard.class.getName()
										+ " p where p.street like :street and p.city.id=:cityId")
						.setParameter("street", "%" + street + "%")
						.setParameter("cityId", cityId));
		return list;
	}

}

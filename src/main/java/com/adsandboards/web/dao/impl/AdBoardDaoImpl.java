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
	public List<AdBoard> getAllBoardsForCriteria(AdBoard adBoard, int start,
			int length) {
		logger.info("street query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,****************:");
		Long cityId = adBoard.getCity() != null ? adBoard.getCity().getId()
				: null;
		List<AdBoard> adBoards = null;
		logger.info("city id.....*********************" + cityId);
		if (cityId != null) {
			adBoards = QueryUtil.listAndCast(this.entityManager
					.createQuery(
							"select u from " + AdBoard.class.getName()
									+ " u where u.city.id=:cityId"
									+ " and u.street like :street")
					.setParameter(
							"street",
							adBoard.getStreet() != null ? "%"
									+ adBoard.getStreet() + "%" : "")
					.setParameter("cityId", cityId).setFirstResult(start)
					.setMaxResults(length));
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

	@Override
	public Long getAllBoardsForCriteriaLength(AdBoard adBoard) {
		logger.info("street query length,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,****************:");
		Long totalCount = 0L;
		Long cityId = adBoard.getCity() != null ? adBoard.getCity().getId()
				: null;
		if (cityId != null) {
			totalCount = (Long) this.entityManager
					.createQuery(
							"select count(*) from " + AdBoard.class.getName()
									+ " u where u.city.id=:cityId"
									+ " and u.street like :street")
					.setParameter(
							"street",
							adBoard.getStreet() != null ? "%"
									+ adBoard.getStreet() + "%" : "")
					.setParameter("cityId", cityId).getSingleResult();
		}
		return totalCount;
	}

}

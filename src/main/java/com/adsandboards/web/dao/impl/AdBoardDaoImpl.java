package com.adsandboards.web.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.AdBoardDao;
import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.model.SearchCriteria;
import com.adsandboards.web.util.QueryUtil;

public class AdBoardDaoImpl extends GenericDaoImpl<AdBoard, Long> implements AdBoardDao {

	static final Logger logger = Logger.getLogger(AdBoardDaoImpl.class);

	public AdBoardDaoImpl() {
		super(AdBoard.class);
	}

	@Override
	public List<AdBoard> getAllBoardsForCriteria(SearchCriteria searchCriteria, int start, int length) {
		logger.info("street query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,****************:");
		Long cityId = searchCriteria.getAdboard().getCity() != null ? searchCriteria.getAdboard().getCity().getId() : null;
		List<AdBoard> adBoards = null;
		logger.info("city id.....*********************" + cityId);
		String query = getSearchQuery(searchCriteria, false);

		if (cityId != null) {
			adBoards = QueryUtil.listAndCast(this.entityManager.createQuery(query).setFirstResult(start).setMaxResults(length));
		}
		/*if (cityId != null) {
			adBoards = QueryUtil.listAndCast(this.entityManager.createQuery("select u from " + AdBoard.class.getName() + " u where u.city.id=:cityId" + " and u.street like :street")
					.setParameter("cityId", cityId).setParameter("street", searchCriteria.getAdboard().getStreet() != null ? "%" + searchCriteria.getAdboard().getStreet() + "%" : "")
					.setFirstResult(start).setMaxResults(length));
		}*/

		return adBoards;
	}

	@Override
	public List<String> getSimilarLandmarkList(Long cityId, String street) {
		List<String> list = QueryUtil.listAndCast(this.entityManager.createQuery("select p.street from " + AdBoard.class.getName() + " p where p.street like :street and p.city.id=:cityId")
				.setParameter("street", "%" + street + "%").setParameter("cityId", cityId));
		return list;
	}

	@Override
	public Long getAllBoardsForCriteriaLength(SearchCriteria searchCriteria) {
		logger.info("street query length,,,,,,,,,,,,,,,,,,,,,BBBBBB,,,,,,,,,,,,****************:");
		logger.info("street query length,,,,,,,,,,,,,,,PRINTTTTTTTTTTTTTTTTTTTT,,,,,,,,,,,,****************:");

		logger.info("detailed location....................*****........." + searchCriteria.getAdboard().getDetailedLocation());
		Long totalCount = 0L;
		Long cityId = searchCriteria.getAdboard().getCity() != null ? searchCriteria.getAdboard().getCity().getId() : null;
		String query = getSearchQuery(searchCriteria, true);
		if (cityId != null) {
			totalCount = (Long) this.entityManager.createQuery(query).getSingleResult();
		}
		/*if (cityId != null) {
			totalCount = (Long) this.entityManager.createQuery("select count(*) from " + AdBoard.class.getName() + " u where u.city.id=:cityId" + " and u.street like :street")
					.setParameter("street", searchCriteria.getAdboard().getStreet() != null ? "%" + searchCriteria.getAdboard().getStreet() + "%" : "").setParameter("cityId", cityId)
					.getSingleResult();
		}*/
		return totalCount;
	}

	private String getSearchQuery(SearchCriteria searchCriteria, boolean count) {
		Long cityId = searchCriteria.getAdboard().getCity() != null ? searchCriteria.getAdboard().getCity().getId() : null;
		String countQuery = "u";
		if (count == true)
			countQuery = "count(*)";
		StringBuilder query = new StringBuilder("select " + countQuery + " from " + AdBoard.class.getName() + " u");
		if (cityId != null) {
			query.append(" where u.city.id=" + cityId + "");
			if (searchCriteria.getAdboard().getStreet() != null && !searchCriteria.getAdboard().getStreet().isEmpty()) {
				query.append(" and u.street like '%" + searchCriteria.getAdboard().getStreet() + "%'");
			}
		}
		if (searchCriteria.getAdboard().getLength() != null) {
			query.append(" and u.length =" + searchCriteria.getAdboard().getLength() + "");
		}
		if (searchCriteria.getAdboard().getLength() != null) {
			query.append(" and u.breadth =" + searchCriteria.getAdboard().getLength() + "");
		}

		if (searchCriteria.getAdboard().getDetailedLocation() != null && !searchCriteria.getAdboard().getDetailedLocation().isEmpty()) {
			query.append(" and u.detailedLocation =" + searchCriteria.getAdboard().getDetailedLocation() + "");
		}
		if (searchCriteria.isAvailable() == true) {
			Date currentDate = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String currentDateString = df.format(currentDate);
			query.append(" and u.contractStartDate <= '" + currentDateString + "' and '" + currentDateString + "' <= date_add_interval(u.contractStartDate,u.contractDays,DAY)");
		}
		return query.toString();
	}
}

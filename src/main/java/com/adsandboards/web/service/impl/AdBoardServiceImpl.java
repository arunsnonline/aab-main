package com.adsandboards.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.AdBoardDao;
import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.model.SearchCriteria;
import com.adsandboards.web.service.AdBoardService;

public class AdBoardServiceImpl extends GenericServiceImpl<AdBoard, Long>
		implements AdBoardService {

	private AdBoardDao adBoardDao;

	@Autowired
	public AdBoardServiceImpl(AdBoardDao adBoardDao) {
		super(adBoardDao);
		this.adBoardDao = adBoardDao;
	}

	@Override
	public List<AdBoard> getAllBoardsForCriteria(SearchCriteria searchCriteria,
			int start, int length) {
		return this.adBoardDao.getAllBoardsForCriteria(searchCriteria, start,
				length);
	}

	@Override
	public List<String> getSimilarLandmarkList(Long cityId, String street) {
		return this.adBoardDao.getSimilarLandmarkList(cityId, street);
	}

	@Override
	public Long getAllBoardsForCriteriaLength(SearchCriteria searchCriteria) {
		return this.adBoardDao.getAllBoardsForCriteriaLength(searchCriteria);
	}
}

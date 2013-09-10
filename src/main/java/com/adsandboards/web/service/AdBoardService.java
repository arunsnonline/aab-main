package com.adsandboards.web.service;

import java.util.List;

import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.model.SearchCriteria;

public interface AdBoardService extends GenericService<AdBoard, Long> {

	public List<AdBoard> getAllBoardsForCriteria(SearchCriteria searchCriteria,
			int start, int length);

	public List<String> getSimilarLandmarkList(Long cityId, String street);

	public Long getAllBoardsForCriteriaLength(SearchCriteria searchCriteria);

}

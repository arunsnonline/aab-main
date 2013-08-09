package com.adsandboards.web.service;

import java.util.List;

import com.adsandboards.web.model.AdBoard;

public interface AdBoardService extends GenericService<AdBoard, Long> {

	public List<AdBoard> getAllBoardsForCriteria(AdBoard adBoard, int start,
			int length);

	public List<String> getSimilarLandmarkList(Long cityId, String street);

	public Long getAllBoardsForCriteriaLength(AdBoard adBoard);

}

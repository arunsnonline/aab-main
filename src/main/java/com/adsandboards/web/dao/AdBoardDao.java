package com.adsandboards.web.dao;

import java.util.List;

import com.adsandboards.web.model.AdBoard;

public interface AdBoardDao extends GenericDao<AdBoard, Long> {

	public List<AdBoard> getAllBoardsForCriteria(AdBoard adBoard);

	public List<String> getSimilarLandmarkList(Long cityId, String street);
}

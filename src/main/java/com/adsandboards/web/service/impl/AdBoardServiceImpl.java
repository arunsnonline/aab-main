package com.adsandboards.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.AdBoardDao;
import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.service.AdBoardService;

public class AdBoardServiceImpl extends GenericServiceImpl<AdBoard, Long>
		implements AdBoardService {

	@Autowired
	public AdBoardServiceImpl(AdBoardDao adBoardDao) {
		super(adBoardDao);
	}
}

package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.AdBoardDao;
import com.adsandboards.web.model.AdBoard;

public class AdBoardDaoImpl extends GenericDaoImpl<AdBoard, Long> implements
		AdBoardDao {

	static final Logger logger = Logger.getLogger(AdBoardDaoImpl.class);

	public AdBoardDaoImpl() {
		super(AdBoard.class);
	}

}

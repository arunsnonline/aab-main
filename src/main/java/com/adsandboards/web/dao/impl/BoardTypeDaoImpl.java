package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.BoardTypeDao;
import com.adsandboards.web.model.BoardType;

public class BoardTypeDaoImpl extends GenericDaoImpl<BoardType, Long> implements
		BoardTypeDao {

	static final Logger logger = Logger.getLogger(BoardTypeDaoImpl.class);

	public BoardTypeDaoImpl() {
		super(BoardType.class);
	}

}

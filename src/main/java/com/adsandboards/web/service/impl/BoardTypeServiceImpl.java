package com.adsandboards.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.BoardTypeDao;
import com.adsandboards.web.model.BoardType;
import com.adsandboards.web.service.BoardTypeService;

public class BoardTypeServiceImpl extends GenericServiceImpl<BoardType, Long>
		implements BoardTypeService {

	@Autowired
	public BoardTypeServiceImpl(BoardTypeDao boardTypeDao) {
		super(boardTypeDao);
	}
}

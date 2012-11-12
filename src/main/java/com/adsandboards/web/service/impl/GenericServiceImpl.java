package com.adsandboards.web.service.impl;

import java.io.Serializable;
import java.util.List;

import com.adsandboards.web.dao.GenericDao;
import com.adsandboards.web.service.GenericService;

public class GenericServiceImpl<T, PK extends Serializable> implements
		GenericService<T, PK> {

	protected GenericDao<T, PK> genericDao;

	public GenericServiceImpl(final GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<T> getAll() {
		return this.genericDao.getAll();
	}

	@Override
	public T get(PK id) {
		return this.genericDao.get(id);
	}

	@Override
	public T save(T object) {
		return this.genericDao.save(object);
	}

	@Override
	public void delete(PK id) {
		this.genericDao.delete(id);
	}
}

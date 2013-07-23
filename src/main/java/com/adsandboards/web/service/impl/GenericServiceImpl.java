package com.adsandboards.web.service.impl;

import java.io.Serializable;
import java.util.List;

import com.adsandboards.web.dao.GenericDao;
import com.adsandboards.web.service.GenericService;

/**
 * 
 * @author arun
 * 
 *         Service layer for all generic operations across all models
 * 
 * @param <T>
 * @param <PK>
 */
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

	@Override
	public List<T> getAll(int start, int length) {
		return this.genericDao.getAll(start, length);
	}

	@Override
	public Long getTotalCount() {
		return this.genericDao.getTotalCount();
	}
}

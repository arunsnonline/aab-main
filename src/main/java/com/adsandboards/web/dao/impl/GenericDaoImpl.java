package com.adsandboards.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.adsandboards.web.dao.GenericDao;

public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	private Class<T> persistentClass;
	@PersistenceContext
	protected EntityManager entityManager;

	public GenericDaoImpl(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		List<T> list = this.entityManager.createQuery(
				"select p from " + persistentClass.getName() + " p")
				.getResultList();
		return list;
	}

	@Override
	public T get(PK id) {
		T entity = (T) this.entityManager.find(this.persistentClass, id);
		return entity;
	}

	@Override
	public T save(T object) {
		return (T) this.entityManager.merge(object);
	}

	@Override
	public void delete(PK id) {
		this.entityManager.remove(this.get(id));
	}

}

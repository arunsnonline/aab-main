package com.adsandboards.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.adsandboards.web.dao.GenericDao;

/**
 * 
 * @author arun
 * 
 *         All generic data access methods.Handles CRUD and total record count
 *         operations
 * 
 * @param <T>
 * @param <PK>
 */
@Transactional
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
		T t = this.entityManager.merge(object);
		this.entityManager.flush();
		return t;

	}

	@Override
	public void delete(PK id) {
		this.entityManager.remove(this.get(id));
	}

	@Override
	public Long getTotalCount() {
		return (Long) this.entityManager
				.createQuery(
						"select count(*) from "
								+ this.persistentClass.getName() + " o")
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(int start, int length) {
		List<T> list = this.entityManager
				.createQuery(
						"select p from " + persistentClass.getName() + " p")
				.setFirstResult(start).setMaxResults(length).getResultList();
		return list;
	}

}

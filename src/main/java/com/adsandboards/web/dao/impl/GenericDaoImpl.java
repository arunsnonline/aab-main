package com.adsandboards.web.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.adsandboards.web.dao.GenericDao;

public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	private Class<T> persistentClass;
	protected HibernateTemplate hibernateTemplate;

	public GenericDaoImpl(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		List<T> list = this.hibernateTemplate.loadAll(this.persistentClass);
		return list;
	}

	@Override
	public T get(PK id) {
		T entity = (T) this.hibernateTemplate.get(this.persistentClass, id);
		return entity;
	}

	@Override
	public T save(T object) {
		return (T) this.hibernateTemplate.merge(object);
	}

	@Override
	public void delete(PK id) {
		this.hibernateTemplate.delete(this.get(id));
	}

}

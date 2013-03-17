package com.adsandboards.web.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, PK extends Serializable> {

	List<T> getAll();

	List<T> getAll(int start, int length);

	T get(PK id);

	T save(T object);

	void delete(PK id);

	Long getTotalCount();

}

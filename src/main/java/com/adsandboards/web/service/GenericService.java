package com.adsandboards.web.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, PK extends Serializable> {

	List<T> getAll();

	T get(PK id);

	T save(T object);

	void delete(PK id);

}

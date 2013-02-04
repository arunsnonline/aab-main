package com.adsandboards.web.util;

import java.util.List;

import javax.persistence.Query;

public class QueryUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> listAndCast(Query q) {
		List list = q.getResultList();
		return list;
	}

}

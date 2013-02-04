package com.adsandboards.web.dao;

import com.adsandboards.web.model.User;

public interface UserDao extends GenericDao<User, Long> {

	public boolean authenticateUser(String userName, String password);

}

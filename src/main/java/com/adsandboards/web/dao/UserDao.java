package com.adsandboards.web.dao;

import java.util.List;

import com.adsandboards.web.model.User;

public interface UserDao extends GenericDao<User, Long> {

	public List<User> authenticateUser(String userName, String password);

}

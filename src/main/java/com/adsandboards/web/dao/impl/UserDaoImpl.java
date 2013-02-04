package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.UserDao;
import com.adsandboards.web.model.User;

public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		return true;
	}

}

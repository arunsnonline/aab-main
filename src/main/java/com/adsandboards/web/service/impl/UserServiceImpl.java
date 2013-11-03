package com.adsandboards.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.UserDao;
import com.adsandboards.web.model.User;
import com.adsandboards.web.service.UserService;

public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super(userDao);
		this.userDao = userDao;
	}

	@Override
	public List<User> authenticateUser(String userName, String password) {
		return this.userDao.authenticateUser(userName, password);
	}
}

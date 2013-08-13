package com.adsandboards.web.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.UserDao;
import com.adsandboards.web.model.User;
import com.adsandboards.web.util.MD5Convertor;
import com.adsandboards.web.util.QueryUtil;

public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		logger.debug("***********userName******:" + userName + ">>>>>>>>>>>"
				+ password);
		password = MD5Convertor.convertToMD5(password);
		List<User> userList = QueryUtil
				.listAndCast(this.entityManager
						.createQuery(
								"select u from "
										+ User.class.getName()
										+ " u where u.username=:username and u.password=:password")
						.setParameter("username", userName)
						.setParameter("password", password));
		logger.debug("***********user list******:" + userList.size());
		return userList.size() > 0 ? true : false;
	}

}

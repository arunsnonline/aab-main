package com.adsandboards.web.service;

import java.util.List;

import com.adsandboards.web.model.User;

public interface UserService extends GenericService<User, Long> {

	public List<User> authenticateUser(String userName, String password);

}

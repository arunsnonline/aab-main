package com.adsandboards.web.service;

import com.adsandboards.web.model.User;

public interface UserService extends GenericService<User, Long> {

	public boolean authenticateUser(String userName, String password);

}

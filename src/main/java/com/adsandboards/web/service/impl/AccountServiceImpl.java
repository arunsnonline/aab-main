package com.adsandboards.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.AccountDao;
import com.adsandboards.web.model.Account;
import com.adsandboards.web.service.AccountService;

public class AccountServiceImpl extends GenericServiceImpl<Account, Long>
		implements AccountService {

	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		super(accountDao);
	}
}

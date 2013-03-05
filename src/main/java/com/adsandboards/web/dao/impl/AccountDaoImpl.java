package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.AccountDao;
import com.adsandboards.web.model.Account;
import com.adsandboards.web.model.Organization;

public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements
		AccountDao {

	static final Logger logger = Logger.getLogger(AccountDaoImpl.class);

	public AccountDaoImpl() {
		super(Account.class);
	}

	@Override
	public Account save(Account account) {
		logger.debug("******************:" + account.getOrganization().getId());
		Organization organization = entityManager.find(Organization.class,
				account.getOrganization().getId());
		account.setOrganization(organization);
		return entityManager.merge(account);
	}

}

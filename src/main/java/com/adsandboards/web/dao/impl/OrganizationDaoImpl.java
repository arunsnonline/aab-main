package com.adsandboards.web.dao.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.dao.OrganizationDao;
import com.adsandboards.web.model.Organization;

public class OrganizationDaoImpl extends GenericDaoImpl<Organization, Long>
		implements OrganizationDao {

	static final Logger logger = Logger.getLogger(OrganizationDaoImpl.class);

	public OrganizationDaoImpl() {
		super(Organization.class);
	}

}

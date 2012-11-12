package com.adsandboards.web.dao.impl;

import com.adsandboards.web.dao.OrganizationDao;
import com.adsandboards.web.model.Organization;

public class OrganizationDaoImpl extends GenericDaoImpl<Organization, Long>
		implements OrganizationDao {

	public OrganizationDaoImpl() {
		super(Organization.class);
	}

}

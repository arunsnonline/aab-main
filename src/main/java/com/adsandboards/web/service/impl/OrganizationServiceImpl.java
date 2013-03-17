package com.adsandboards.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.adsandboards.web.dao.OrganizationDao;
import com.adsandboards.web.model.Organization;
import com.adsandboards.web.service.OrganizationService;

public class OrganizationServiceImpl extends
		GenericServiceImpl<Organization, Long> implements OrganizationService {

	@Autowired
	public OrganizationServiceImpl(OrganizationDao organizationDao) {
		super(organizationDao);
	}

}

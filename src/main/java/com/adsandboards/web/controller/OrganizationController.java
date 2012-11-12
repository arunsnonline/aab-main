package com.adsandboards.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsandboards.web.model.Organization;
import com.adsandboards.web.service.OrganizationService;

@Controller
@RequestMapping(value = "/admin/org")
public class OrganizationController extends
		GenericController<Organization, Long> {

	@Autowired
	public OrganizationController(OrganizationService organizationService) {
		super(organizationService);
	}

	@Override
	protected Organization getNewCommand() {
		return new Organization();
	}

	@Override
	protected String getListPageName() {
		return "orglist";
	}

	@Override
	protected String getListCommandName() {
		return "organizationList";
	}

	@Override
	protected String getEditPageName() {
		return "orgedit";
	}

	@Override
	protected String getRedirectName() {
		return "/admin/org";
	}

}

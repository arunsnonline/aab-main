package com.adsandboards.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsandboards.web.model.Account;
import com.adsandboards.web.service.AccountService;
import com.adsandboards.web.service.OrganizationService;

@Controller
@RequestMapping(value = "/admin/acc")
public class AccountController extends GenericController<Account, Long> {

	static final Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	public AccountController(AccountService accountService) {
		super(accountService);
	}

	@Override
	protected void setAdditionalModelsForForm(ModelMap model) {
		model.put("organizationList", organizationService.getAll());
	}

	@Override
	protected Account getNewCommand() {
		return new Account();
	}

	@Override
	protected String getListPageName() {
		return "acclist";
	}

	@Override
	protected String getListCommandName() {
		return "accountList";
	}

	@Override
	protected String getEditPageName() {
		return "accedit";
	}

	@Override
	protected String getRedirectName() {
		return "/admin/acc";
	}

}

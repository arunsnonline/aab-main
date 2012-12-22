package com.adsandboards.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsandboards.web.model.Country;
import com.adsandboards.web.service.CountryService;

@Controller
@RequestMapping(value = "/admin/country")
public class CountryController extends GenericController<Country, Long> {

	@Autowired
	public CountryController(CountryService countryService) {
		super(countryService);
	}

	@Override
	protected Country getNewCommand() {
		return new Country();
	}

	@Override
	protected String getListPageName() {
		return "countrylist";
	}

	@Override
	protected String getListCommandName() {
		return "countryList";
	}

	@Override
	protected String getEditPageName() {
		return "countryedit";
	}

	@Override
	protected String getRedirectName() {
		return "/admin/country";
	}

}

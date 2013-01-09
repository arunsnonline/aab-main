package com.adsandboards.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsandboards.web.model.City;
import com.adsandboards.web.service.CityService;
import com.adsandboards.web.service.StateService;

@Controller
@RequestMapping(value = "/admin/city")
public class CityController extends GenericController<City, Long> {

	static final Logger logger = Logger.getLogger(CityController.class);

	@Autowired
	private StateService stateService;

	@Autowired
	public CityController(CityService cityService) {
		super(cityService);
	}

	@Override
	protected void setAdditionalModelsForForm(ModelMap model) {
		model.put("stateList", stateService.getAll());
	}

	@Override
	protected City getNewCommand() {
		return new City();
	}

	@Override
	protected String getListPageName() {
		return "citylist";
	}

	@Override
	protected String getListCommandName() {
		return "cityList";
	}

	@Override
	protected String getEditPageName() {
		return "cityedit";
	}

	@Override
	protected String getRedirectName() {
		return "/admin/city";
	}
}

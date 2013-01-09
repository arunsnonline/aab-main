package com.adsandboards.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsandboards.web.model.State;
import com.adsandboards.web.service.CountryService;
import com.adsandboards.web.service.StateService;

@Controller
@RequestMapping(value = "/admin/state")
public class StateController extends GenericController<State, Long> {

	static final Logger logger = Logger.getLogger(StateController.class);

	@Autowired
	private CountryService countryService;

	@Autowired
	public StateController(StateService stateService) {
		super(stateService);
	}

	@Override
	protected void setAdditionalModelsForForm(ModelMap model) {
		model.put("countryList", countryService.getAll());
	}

	@Override
	protected State getNewCommand() {
		return new State();
	}

	@Override
	protected String getListPageName() {
		return "statelist";
	}

	@Override
	protected String getListCommandName() {
		return "stateList";
	}

	@Override
	protected String getEditPageName() {
		return "stateedit";
	}

	@Override
	protected String getRedirectName() {
		return "/admin/state";
	}

}

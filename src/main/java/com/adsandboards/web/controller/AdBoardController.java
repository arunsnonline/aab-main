package com.adsandboards.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.service.AdBoardService;
import com.adsandboards.web.service.BoardTypeService;
import com.adsandboards.web.service.CityService;

@Controller
@RequestMapping(value = "/admin/adboard")
public class AdBoardController extends GenericController<AdBoard, Long> {

	static final Logger logger = Logger.getLogger(AdBoardController.class);

	@Autowired
	private BoardTypeService boardTypeService;

	@Autowired
	private CityService cityService;

	@Autowired
	public AdBoardController(AdBoardService adBoardService) {
		super(adBoardService);
	}

	@Override
	protected void setAdditionalModelsForForm(ModelMap model) {
		model.put("boardTypeList", boardTypeService.getAll());
		model.put("cityList", cityService.getAll());
	}

	@Override
	protected AdBoard getNewCommand() {
		return new AdBoard();
	}

	@Override
	protected String getListPageName() {
		return "adboardlist";
	}

	@Override
	protected String getListCommandName() {
		return "adboardList";
	}

	@Override
	protected String getEditPageName() {
		return "adboardedit";
	}

	@Override
	protected String getRedirectName() {
		return "/admin/adboard";
	}

}

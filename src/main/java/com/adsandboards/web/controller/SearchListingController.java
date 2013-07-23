package com.adsandboards.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.service.AdBoardService;

@Controller
public class SearchListingController {

	@Autowired
	private AdBoardService adBoardService;

	@RequestMapping(value = "/search/boards", method = RequestMethod.POST)
	public String getBoardsForSearch(
			@ModelAttribute("adboard") AdBoard adBoard, ModelMap modelMap,
			BindingResult bindingResult) {
		return "searchresults";
	}

}

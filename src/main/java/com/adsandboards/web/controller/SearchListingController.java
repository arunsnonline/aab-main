package com.adsandboards.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adsandboards.web.model.AdBoard;

@Controller
public class SearchListingController {

	@RequestMapping(value = "/search/adboards", method = RequestMethod.POST)
	public String getBoardsForSearch(
			@ModelAttribute("adboard") AdBoard adBoard,
			BindingResult bindingResult, ModelMap modelMap) {
		modelMap.put("adboard", adBoard);
		return "searchresults";
	}

}

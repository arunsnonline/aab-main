package com.adsandboards.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adsandboards.web.model.Country;
import com.adsandboards.web.service.CountryService;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/country/list.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> getCountryListStartsWithName(
			@RequestParam(value = "cname_startsWith") String countryName) {
		List<Country> countryList = this.countryService
				.getCountryListStartsWithName(countryName);
		return countryList;
	}
}

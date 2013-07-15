package com.adsandboards.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adsandboards.web.model.City;
import com.adsandboards.web.model.Country;
import com.adsandboards.web.model.State;
import com.adsandboards.web.service.CityService;
import com.adsandboards.web.service.CountryService;
import com.adsandboards.web.service.StateService;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/country/list.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> getCountryListStartsWithName(
			@RequestParam(value = "cname_startsWith") String countryName) {
		List<Country> countryList = this.countryService
				.getCountryListStartsWithName(countryName);
		return countryList;
	}

	@RequestMapping(value = "/state/list.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<State> getStateListStartsWithName(
			@RequestParam(value = "stateNameStartsWith") String stateNameStartsWith,
			@RequestParam(value = "countryId") Long countryId) {
		List<State> stateList = this.stateService.getStateListStartsWithName(
				stateNameStartsWith, countryId);
		return stateList;
	}

	@RequestMapping(value = "/city/list.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<City> getCityListStartsWithName(
			@RequestParam(value = "cityNameStartsWith") String cityNameStartsWith,
			@RequestParam(value = "stateId") Long stateId) {
		List<City> cityList = this.cityService.getCityListStartsWithName(
				cityNameStartsWith, stateId);
		return cityList;
	}
}

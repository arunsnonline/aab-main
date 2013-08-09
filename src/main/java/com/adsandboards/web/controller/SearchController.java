package com.adsandboards.web.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adsandboards.web.model.AdBoard;
import com.adsandboards.web.model.City;
import com.adsandboards.web.model.Country;
import com.adsandboards.web.model.DisplayGrid;
import com.adsandboards.web.model.State;
import com.adsandboards.web.service.AdBoardService;
import com.adsandboards.web.service.CityService;
import com.adsandboards.web.service.CountryService;
import com.adsandboards.web.service.StateService;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	static final Logger logger = Logger.getLogger(SearchController.class);

	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AdBoardService adBoardService;

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

	@RequestMapping(value = "/street/list.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getCityListStartsWithName(
			@RequestParam(value = "cityId") Long cityId,
			@RequestParam(value = "street") String street) {
		List<String> landmarkList = this.adBoardService.getSimilarLandmarkList(
				cityId, street);
		return landmarkList;
	}

	@RequestMapping(value = "/adboards/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public DisplayGrid<AdBoard> getSearchBoardResults(
			@RequestParam(value = "iDisplayStart") int start,
			@RequestParam(value = "iDisplayLength") int length,
			@RequestParam(value = "adboardJson") String adboardJson)
			throws JsonParseException, JsonMappingException, IOException {
		logger.debug("adboard struing*****************************************************"
				+ adboardJson);
		AdBoard adBoard = new ObjectMapper().readValue(adboardJson,
				AdBoard.class);
		logger.debug("inside seach board*****************************************************"
				+ adBoard);
		logger.debug("start:" + start);
		logger.debug("length:" + length);
		logger.debug("adboard data:" + adBoard.getStreet());

		Long totalCount = this.adBoardService
				.getAllBoardsForCriteriaLength(adBoard);
		List<AdBoard> list = this.adBoardService.getAllBoardsForCriteria(
				adBoard, start, length);
		DisplayGrid<AdBoard> displayGrid = new DisplayGrid<AdBoard>(totalCount,
				totalCount, list);
		return displayGrid;
	}
}

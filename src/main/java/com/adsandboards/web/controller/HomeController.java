package com.adsandboards.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/home.htm")
	public String home() {
		logger.info("inside home controller");
		return "home";
	}
}

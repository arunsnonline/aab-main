package com.adsandboards.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

	static final Logger logger = Logger.getLogger(AdminController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String viewMenu() {
		return "adminmenu";
	}

}

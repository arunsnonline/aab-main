package com.adsandboards.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	static final Logger logger = Logger.getLogger(AdminController.class);

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String viewMenu() {
		return "adminmenu";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("userInSession", null);
		return "redirect:adminpanel";
	}

	@RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
	public String viewAdminLogin() {
		return "adminlogin";
	}

}

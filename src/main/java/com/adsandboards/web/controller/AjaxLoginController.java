package com.adsandboards.web.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adsandboards.web.service.UserService;

@Controller
public class AjaxLoginController {

	@Resource(name = "userService")
	private UserService userService;

	static final Logger logger = Logger.getLogger(AjaxLoginController.class);

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean login(@RequestParam(value = "username") String userName,
			@RequestParam(value = "password") String password) {
		return userService.authenticateUser(userName, password);
	}
}

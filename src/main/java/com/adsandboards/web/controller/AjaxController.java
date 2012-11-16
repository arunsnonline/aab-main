package com.adsandboards.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	// @Resource(name = "loginService")
	// private Calculator calculator;

	static final Logger logger = Logger.getLogger(AjaxController.class);

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean login(@RequestParam(value = "username") String userName,
			@RequestParam(value = "password") String password) {
		logger.info("inside ajax controller" + userName + "  password:"
				+ password);
		// Integer sum = calculator.add(input1, input2);
		// logger.info("calculated sum" + sum);
		return false;
	}
}

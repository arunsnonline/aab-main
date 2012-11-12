package com.adsandboards.web.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adsandboards.web.service.Calculator;

@Controller
public class AjaxController {

	@Resource(name = "calculatorService")
	private Calculator calculator;

	static final Logger logger = Logger.getLogger(AjaxController.class);

	@RequestMapping(value = "/add.htm", method = RequestMethod.POST)
	public @ResponseBody
	Integer add(@RequestParam(value = "input1") Integer input1,
			@RequestParam(value = "input2") Integer input2) {
		logger.info("inside ajax controller");
		Integer sum = calculator.add(input1, input2);
		logger.info("calculated sum" + sum);
		return sum;
	}
}

package com.adsandboards.web.service.impl;

import org.apache.log4j.Logger;

import com.adsandboards.web.service.Calculator;

public class CalculatorImpl implements Calculator {

	private static final Logger logger = Logger.getLogger(CalculatorImpl.class);

	@Override
	public int add(int a, int b) {
		logger.info("inside impl");
		return a + b;
	}

}

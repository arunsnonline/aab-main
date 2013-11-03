package com.adsandboards.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.adsandboards.web.model.User;
import com.adsandboards.web.service.UserService;

@Controller
@SessionAttributes("userInSession")
public class AjaxLoginController {

	@Resource(name = "userService")
	private UserService userService;

	static final Logger logger = Logger.getLogger(AjaxLoginController.class);

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean login(ModelMap modelMap, @RequestParam(value = "username") String userName, @RequestParam(value = "password") String password) {
		List<User> userList = userService.authenticateUser(userName, password);
		boolean isValidUser = userList.size() > 0 ? true : false;
		if (isValidUser)
			modelMap.put("userInSession", userList.get(0));
		return isValidUser;
	}
}

package com.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.model.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/app")
	public ModelAndView getApp(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean auth = loginService.login(username, password);
		
		if(auth) {
			mav.addObject("message", "You're signed in");
		} else {
			mav.addObject("message", "Incorrect credentials");
		}
		mav.setViewName("app");
		
		return mav;
	}
	
	@RequestMapping("/")
	public ModelAndView getLogin() {
		return new ModelAndView("login");
	}
}

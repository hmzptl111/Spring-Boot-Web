package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.service.GreetingService;

@Controller
public class GreetingController {
	@Autowired
	private GreetingService greetingService;
	
	@RequestMapping("/")
	public ModelAndView getGreetingController() {
		ModelAndView mav = new ModelAndView();
		String name = greetingService.greeting();
		mav.addObject("name", name);
		mav.setViewName("greetingView");
		
		return mav;
	}
}

package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class UserController
{
	@RequestMapping(value = "/") 
	public ModelAndView index()
	{
 		ModelAndView model = new ModelAndView("/index");
		
		return model;
	}

}

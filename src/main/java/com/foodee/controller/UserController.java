package com.foodee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	 public ModelAndView home() {
	  return new ModelAndView("Home");
	 }
	 
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	 public ModelAndView Login() {
	  return new ModelAndView("manageFoodItems");
	 }
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	 public ModelAndView adminPage() {
	  return new ModelAndView("wanderlust");
	 }	
	

}

package com.webapp.foodister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to home");
			
			return new ModelAndView("home");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to login");
			
			return new ModelAndView("login");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to register");
			
			return new ModelAndView("register");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView forgotPassword(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to forgotpassword");
			
			return new ModelAndView("forgotpassword");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	
}

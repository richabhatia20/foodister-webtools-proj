package com.webapp.foodister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(value = "/adminstatistics", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to adminstatistics");
			
			return new ModelAndView("admin-statistics");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public ModelAndView adminhome(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to adminhome");
			
			return new ModelAndView("admin-home");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
}

package com.webapp.foodister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView loginSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			System.out.println("Inside login submit");
			HttpSession session = request.getSession();
			session.setAttribute("user", "User");
			
			return new ModelAndView("home");
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Inside logout");
			HttpSession session = request.getSession();
			
			session.invalidate();
			
			return new ModelAndView("login");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
}

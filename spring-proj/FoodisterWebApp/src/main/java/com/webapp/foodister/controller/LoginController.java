package com.webapp.foodister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.foodister.dao.UserDAO;
import com.webapp.foodister.pojo.Customer;
import com.webapp.foodister.pojo.Owner;
import com.webapp.foodister.pojo.User;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView loginSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			System.out.println("Inside login submit");
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			
			User user = userDao.checkUserNameAndPassword(username, password);
			if(user != null)
			{
				HttpSession session = request.getSession();
				System.out.println("User found");
				
				if(user instanceof Customer)
				{
					
				System.out.println("is a customer");
				session.setAttribute("Role", "Customer");
				}
				else if(user instanceof Owner)
				{
				
				System.out.println("is a owner");	
				session.setAttribute("Role", "Owner");	
				}
				session.setAttribute("User", user);
				
				
				return new ModelAndView("home");
			}
			
			else{
				System.out.println("no credentials found");
				return new ModelAndView("login","loginError", "Invalid Credentials! Please try again");
				
			}
			
			
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
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchRestaurants(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Inside searchRestaurants");
			
			return new ModelAndView("home");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}

}

package com.webapp.foodister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.foodister.dao.MessageDAO;
import com.webapp.foodister.dao.UserDAO;
import com.webapp.foodister.pojo.Admin;
import com.webapp.foodister.pojo.Customer;
import com.webapp.foodister.pojo.Messages;
import com.webapp.foodister.pojo.Owner;
import com.webapp.foodister.pojo.User;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private MessageDAO messageDao;
	
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
				
				session.setAttribute("User", user);
				
				if(user instanceof Customer)
				{
					
				System.out.println("is a customer");
				session.setAttribute("Role", "Customer");
				}
				else if(user instanceof Owner)
				{
				
				System.out.println("is a owner");	
				session.setAttribute("Role", "Owner");
				return new ModelAndView("owner-home");
				}
				
				else if(user instanceof Admin){
					System.out.println("is a admin");
					session.setAttribute("Role", "Admin");
					return new ModelAndView("admin-home");
				}
				
				
				
				
				
				
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
	
	@RequestMapping(value = "/addMessage.htm", method = RequestMethod.POST)
	public ModelAndView messageSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			System.out.println("Inside message submit");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String message = request.getParameter("message");
			
			Messages m = new Messages(name, email, message) ;
			
			Boolean flag = messageDao.addNewMessage(m);
			
			if(flag)
			{
					
				System.out.println("Message added successfully");
				return new ModelAndView("home" ,"messageStatus", "Message sent successfully!");
			}
			
			else{
				System.out.println("Message not sent");
				return new ModelAndView("home" ,"messageStatus", "Message not sent. Please try again later!");
				
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
		
	}
	

}

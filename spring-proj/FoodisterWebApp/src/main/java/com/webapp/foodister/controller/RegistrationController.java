package com.webapp.foodister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.foodister.dao.UserDAO;
import com.webapp.foodister.pojo.Customer;
import com.webapp.foodister.pojo.Owner;
import com.webapp.foodister.pojo.User;



@Controller
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
//	@Autowired
//	@Qualifier("userValidator")
//	private Validator validator;
//	
	@Autowired
	private UserDAO userDao;
	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	public ModelAndView registerSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			System.out.println("Inside register submit");
			logger.info("printing logger");
			String fname = request.getParameter("firstName");
			String lname = request.getParameter("lastName");
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("emailId");
			
			String option = request.getParameter("accountType");
			System.out.println("printing user name:"  + fname + lname + username + password + email + " account type: " + option);
			
			boolean flag =userDao.isUniqueUser(email, username);
			boolean successFlag;
			if(flag)
			{
				
				if(option.equalsIgnoreCase("customer"))
				{
					
					
					Customer c = new Customer(fname, lname, email, username, password);
					successFlag = userDao.addNewUSer(c);
					
					if(successFlag)
					{
						System.out.println("Customer saved successfully");
					}
					
				}
				if(option.equalsIgnoreCase("owner"))
				{
					Owner o = new Owner(fname, lname, email, username, password);
					successFlag = userDao.addNewUSer(o);
					
					if(successFlag)
					{
						System.out.println("Owner saved successfully");
					}
					
				}
				
			}
			else{
				
				
				//return new ModelAndView("register");
				System.out.println("duplicate details");
				return new ModelAndView("register","registerError", "Username already exists! Please try again");
			}
			
			
			
			
			return new ModelAndView("login");
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
		
	}

}

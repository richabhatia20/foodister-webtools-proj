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
import com.webapp.foodister.pojo.User;



@Controller
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@Autowired
	private UserDAO userDao;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	public ModelAndView registerSubmit(Model model, @ModelAttribute("user") @Validated User user,HttpServletRequest request, HttpServletResponse response)
	{
		try{
			System.out.println("Inside register submit");
			
			System.out.println("printing user name:"  + user.getUserName());
			
			
			return new ModelAndView("login");
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
		
	}

}

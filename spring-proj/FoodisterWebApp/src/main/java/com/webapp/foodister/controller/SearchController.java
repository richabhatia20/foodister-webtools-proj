package com.webapp.foodister.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.foodister.dao.OwnerDAO;
import com.webapp.foodister.dao.SearchDAO;
import com.webapp.foodister.pojo.Restaurant;


@Controller
public class SearchController {

	@Autowired
	private SearchDAO searchDao;

	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchRestaurants(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Inside searchRestaurants");
			
			
			String location = request.getParameter("location");
			String searchtext = request.getParameter("searchRestaurant");
			
			System.out.println("printing location and searchtext: " + location +" and " + searchtext);
			
			List<Restaurant> restaurants = searchDao.fetchAllRestuarantsBySearch(location, searchtext);
			
			for(Restaurant r: restaurants)
			{
				System.out.println("name of restaurant found: "+r.getName());
			}
			
			// command object
						model.addAttribute("restaurants", restaurants);

			
			return "restaurant";
				
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();

			model.addAttribute("errorMessage", "No page to display");
			return "error";

		}
		
	}
	
}

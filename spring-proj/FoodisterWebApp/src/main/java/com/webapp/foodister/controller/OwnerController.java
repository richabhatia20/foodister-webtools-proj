package com.webapp.foodister.controller;

import java.io.File;
//import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.webapp.foodister.dao.OwnerDAO;
import com.webapp.foodister.pojo.Menu;
import com.webapp.foodister.pojo.MenuItem;
//import com.webapp.foodister.pojo.Photo;

@Controller
public class OwnerController {
	
	@Autowired
	private MenuItem menuItem;
	
	@Autowired
	private Menu menu;
	
	@Autowired
	private OwnerDAO ownerDao;
	

	@Autowired
	ServletContext servletContext;

	
	@RequestMapping(value = "/ownerhome", method = RequestMethod.GET)
	public ModelAndView ownerHome(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to ownerhome");
			
			return new ModelAndView("owner-home");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	@RequestMapping(value = "/ownerprofile", method = RequestMethod.GET)
	public ModelAndView ownerProfile(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to ownerprofile");
			
			return new ModelAndView("owner-profile");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	
	@RequestMapping(value = "/addrestuarant", method = RequestMethod.GET)
	public ModelAndView addRestaurant(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to addRestaurant");
			
			return new ModelAndView("owner-addrestuarant");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	
	@RequestMapping(value = "/addmenuitem", method = RequestMethod.GET)
	public String addMenuItem(ModelMap model) {
		
		try{
			
			System.out.println("Navigating to addMenuItem");
			
			//return new ModelAndView("owner-addmenuitem");
			
			
			// command object
			model.addAttribute("menuitem", menuItem);

			// return form view
			return "owner-addmenuitem";
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			
			model.addAttribute("errorMessage", "No page to display");
			return "error";
		}
		
	}

	@RequestMapping(value = "/addmenu", method = RequestMethod.GET)
	public ModelAndView addMenu() {
		
		try{
			
			System.out.println("Navigating to addmenu");
			
			List<MenuItem> items = ownerDao.fetchAllMenuItems();
			
			System.out.println("printing all menu items" + items.size());
			
			return new ModelAndView("owner-addmenu", "menuitems", items);
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}


	
	@RequestMapping(value = "/viewreviews", method = RequestMethod.GET)
	public ModelAndView viewReviews(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			System.out.println("Navigating to viewreviews");
			
			return new ModelAndView("owner-viewreviews");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}
	
	//All POST methods start from here



	@RequestMapping(value = "/addmenuitem.htm", method = RequestMethod.POST)
	public String addNewMenuItem(ModelMap model, @ModelAttribute("menuitem") MenuItem menuitem,  BindingResult result, HttpServletRequest req) {
		
		try{
			
			System.out.println("Inside addNewMenuItem");
			
			
			System.out.println("printing menuitem" + menuitem.getItemName());
			System.out.println("photoobject"+ menuitem.getPhoto());
			
			///////
			
			
//			
				
			
//			Boolean flag = ownerDao.addNewMenuItem(mi);
//			
//			if(flag)
//			{
//					
//				System.out.println("Menu Item added successfully");
//				return new ModelAndView("owner-addmenuitem" ,"addStatus", "success");
//			}
//			
//			else{
//				System.out.println("Menu Item not added");
//				return new ModelAndView("owner-addmenuitem" ,"addStatus", "failure");
//				
//			}
			
			
			
			if (menuitem.getFilename().trim() != "" || menuitem.getFilename() != null) {
				File directory;
				String check = File.separator; // Checking if system is linux
												// based or windows based by
												// checking seprator used.
				String path = null;
				if (check.equalsIgnoreCase("\\")) {
					path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																				  // so we need to replace build in the path
																						}

				if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					path += "/"; // Adding trailing slash for Mac systems.
				}
				
				System.out.println("printing path: "+ path);
				directory = new File(path + "\\" + menuitem.getFilename());
				boolean temp = directory.exists();
				if (!temp) {
					temp = directory.mkdir();
				}
				if (temp) {
					// We need to transfer to a file
					CommonsMultipartFile photoInMemory = menuitem.getPhoto();

					System.out.println("printing photoInMemory size: " + photoInMemory.getSize());
					
					String fileName = photoInMemory.getOriginalFilename();
					// could generate file names as well

					File localFile = new File(directory.getPath(), fileName);

					// move the file from memory to the file

					photoInMemory.transferTo(localFile);
					menuitem.setFilename(localFile.getPath());
					System.out.println("File is stored at" + localFile.getPath());
					System.out.print("addNewMenuItem");
					//User u = userDao.register(user);
					MenuItem miSaved = ownerDao.addNewMenuItem(menuitem);
					
					if(miSaved != null){
						
						model.addAttribute("addStatus", "Item Added Successfully!");	
					}
					

				} else {
					System.out.println("Failed to create directory!");
					model.addAttribute("addStatus", "Failed to add item, Please try again!");
				}
			}

		}catch(Exception e)
		{
			
			System.out.println("error occurred :");
			model.addAttribute("successFlag", "Failed to add item!");
			//return new ModelAndView("error", "errorMessage", "No page to display");
			e.printStackTrace();
		}
		return "owner-addmenuitem";
	}
	
	@RequestMapping(value = "/addmenu.htm", method = RequestMethod.POST)
	public ModelAndView addNewMenu() {
		
		try{
			
			System.out.println("Navigating to addNewMenu");
			
			return new ModelAndView("owner-addmenu");
				
			
			
		}catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}
		
	}


}

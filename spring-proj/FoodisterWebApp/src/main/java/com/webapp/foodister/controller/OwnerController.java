package com.webapp.foodister.controller;

import java.io.File;
import java.util.ArrayList;
//import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.webapp.foodister.pojo.Owner;
//import com.webapp.foodister.pojo.Photo;
import com.webapp.foodister.pojo.Restaurant;

@Controller
public class OwnerController {

	@Autowired
	private MenuItem menuItem;

	@Autowired
	private Menu menu;
	
	@Autowired
	private Restaurant restaurant;

	@Autowired
	private OwnerDAO ownerDao;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/ownerhome", method = RequestMethod.GET)
	public ModelAndView ownerHome(HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to ownerhome");

			return new ModelAndView("owner-home");

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/ownerprofile", method = RequestMethod.GET)
	public String ownerProfile(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to ownerprofile");
			
			HttpSession session = request.getSession();
			
			Owner o =(Owner) session.getAttribute("User");
			
			System.out.println("printing name: "+ o.getFirstName());
			
			
			model.addAttribute("profileOwner", o);
			
			return "owner-profile";
			
			

		} catch (Exception e) {

//			System.out.println(e.getMessage());
//			return new ModelAndView("error", "errorMessage", "No page to display");
			

			System.out.println(e.getMessage());
			model.addAttribute("errorMessage", "No page to display");
			return "error";

		}

	}

	@RequestMapping(value = "/addrestuarant", method = RequestMethod.GET)
	public String addRestaurant(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to addRestaurant");
			
			model.addAttribute("restaurantC", restaurant);

			
			 List<Menu> menus = ownerDao.fetchAllMenus();

			System.out.println("printing all menus: " + menus.size());

			model.addAttribute("menus", menus);

			return "owner-addrestuarant";
			

		} catch (Exception e) {

			System.out.println(e.getMessage());
			model.addAttribute("errorMessage", "No page to display");
			return "error";
		}

	}

	@RequestMapping(value = "/addmenuitem", method = RequestMethod.GET)
	public String addMenuItem(ModelMap model) {

		try {

			System.out.println("Navigating to addMenuItem");

			// return new ModelAndView("owner-addmenuitem");

			// command object
			model.addAttribute("menuitem", menuItem);

			// return form view
			return "owner-addmenuitem";

		} catch (Exception e) {

			System.out.println(e.getMessage());

			model.addAttribute("errorMessage", "No page to display");
			return "error";
		}

	}

	@RequestMapping(value = "/addmenu", method = RequestMethod.GET)
	public ModelAndView addMenu() {

		try {

			System.out.println("Navigating to addmenu");

			List<MenuItem> items = ownerDao.fetchAllMenuItems();

			System.out.println("printing all menu items" + items.size());

			return new ModelAndView("owner-addmenu", "menuitems", items);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/viewreviews", method = RequestMethod.GET)
	public ModelAndView viewReviews(HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to viewreviews");

			return new ModelAndView("owner-viewreviews");

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/viewrestaurants", method = RequestMethod.GET)
	public String viewRestuarants(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to viewRestuarants");
			
			HttpSession session = request.getSession();
			
			Owner o =(Owner) session.getAttribute("User");
			
			System.out.println("printing owner name: " + o.getFirstName());
			

			List<Restaurant> restaurants = ownerDao.fetchAllRestuarantsForOwner(o);

			System.out.println("printing all restaurants" + restaurants.size());
			
			

			// command object
			model.addAttribute("restaurants", restaurants);

			// return form view
			return "owner-viewrestaurants";

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			model.addAttribute("errorMessage", "No page to display");
			return "error";
		}

	}

	// All POST methods start from here

	@RequestMapping(value = "/addmenuitem.htm", method = RequestMethod.POST)
	public String addNewMenuItem(ModelMap model, @ModelAttribute("menuitem") MenuItem menuitem, BindingResult result,
			HttpServletRequest req) {

		try {

			System.out.println("Inside addNewMenuItem");
			System.out.println("printing menuitem" + menuitem.getItemName());
			System.out.println("photoobject" + menuitem.getPhoto());

			if (menuitem.getFilename().trim() != "" || menuitem.getFilename() != null) {
				File directory;
				String check = File.separator; // Checking if system is linux
												// based or windows based by
												// checking seprator used.
				String path = null;
				if (check.equalsIgnoreCase("\\")) {
					path = servletContext.getRealPath("").replace("build\\", ""); 
				}

				if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					path += "/"; // Adding trailing slash for Mac systems.
				}

				System.out.println("printing path: " + path);
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
					// User u = userDao.register(user);
					MenuItem miSaved = ownerDao.addNewMenuItem(menuitem);

					if (miSaved != null) {

						model.addAttribute("addStatus", "Item Added Successfully!");
					}

				} else {
					System.out.println("Failed to create directory!");
					model.addAttribute("addStatus", "Failed to add item, Please try again!");
				}
			}

		} catch (Exception e) {

			System.out.println("error occurred :");
			model.addAttribute("addStatus", "Failed to add item!");
			// return new ModelAndView("error", "errorMessage", "No page to
			// display");
			e.printStackTrace();
		}
		return "owner-addmenuitem";
	}

	@RequestMapping(value = "/addmenu.htm", method = RequestMethod.POST)
	public String addNewMenu(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to addNewMenu");
			
			String desc = request.getParameter("description");
			String[] selectedMenuItems = request.getParameterValues("itemList");
			
			System.out.println("printing desc: " + desc);
			System.out.println("printing selected menu items" + selectedMenuItems.toString());
			
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			
			for(String menuitem : selectedMenuItems)
			{
			System.out.println("printing each menuitem:" + menuitem);	
			MenuItem mi = ownerDao.fetchMenuItemByName(menuitem);
			
			menuItemList.add(mi);
			
			}
			
			Menu menu = new Menu(desc);
			menu.setItemList(menuItemList);
			System.out.println("printing size of list: " + menuItemList.size());
			boolean status = ownerDao.addNewMenu(menu);
			
			if (status == true) {

				model.addAttribute("addStatus", "Menu Added Successfully!");
			}

		 else {
			System.out.println("Failed to save menu!");
			model.addAttribute("addStatus", "Failed to add menu, Please try again!");
		}
			
			

		} catch (Exception e) {

			System.out.println(e.getMessage());
			model.addAttribute("addStatus", "Error occured in adding Menu");
		}
		
		return "owner-addmenu";
	}

	
	@RequestMapping(value = "/addrestaurant.htm", method = RequestMethod.POST)
	public String addNewRestaurant(ModelMap model, @ModelAttribute("restaurantC") Restaurant restaurantC, BindingResult result, HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to addRestaurant");
			
			System.out.println("printing restaurant name: " +restaurantC.getName());
			
			System.out.println("printing menu: " + restaurantC.getMenu().getDescription());
			
			
			Menu m = ownerDao.fetchMenuByDescription(restaurantC.getMenu().getDescription(), restaurantC);

			restaurantC.addMenu(m);
			
			HttpSession session = request.getSession();
			
			Owner o =(Owner) session.getAttribute("User");
			
			System.out.println("printing name: "+ o.getFirstName());
			
			//model.addAttribute("restaurant", restaurant);
			
			m.setRestaurant(restaurantC);
			
			restaurantC.setOwnedBy(o);
			
			Restaurant rSaved = ownerDao.addNewRestaurant(restaurantC,m);
			if (rSaved != null) {

				model.addAttribute("addStatus", "Restaurant Added Successfully!");
			}

		 else {
			System.out.println("Failed to create directory!");
			model.addAttribute("addStatus", "Failed to add restaurant, Please try again!");
		}

			
			return "owner-addrestuarant";
			
			

		} catch (Exception e) {

			System.out.println(e.getMessage());
			model.addAttribute("errorMessage", "An error has occurred. Please contact admin");
			return "error";
		}

	}
	
	@RequestMapping(value = "/updateprofile.htm", method = RequestMethod.POST)
	public String updateOwnerProfile(ModelMap model, @ModelAttribute("profileOwner") Owner profileOwner, BindingResult result, HttpServletRequest request, HttpServletResponse response) {

		try {

			System.out.println("Navigating to updateOwnerProfile");
			
			boolean status = ownerDao.updateOwnerProfile(profileOwner);
			
			if (status == true) {

				model.addAttribute("addStatus", "Profile Updated Successfully!");
			}

		 else {
			System.out.println("Failed to save menu!");
			model.addAttribute("addStatus", "Failed to update profile, Please try again!");
		}

			
//			System.out.println("printing restaurant name: " +restaurantC.getName());
//			
//			System.out.println("printing menu: " + restaurantC.getMenu().getDescription());
//			
//			
//			Menu m = ownerDao.fetchMenuByDescription(restaurantC.getMenu().getDescription(), restaurantC);
//
//			restaurantC.addMenu(m);
//			
//			HttpSession session = request.getSession();
//			
//			Owner o =(Owner) session.getAttribute("User");
//			
//			System.out.println("printing name: "+ o.getFirstName());
//			
//			//model.addAttribute("restaurant", restaurant);
//			
//			m.setRestaurant(restaurantC);
//			
//			restaurantC.setOwnedBy(o);
//			
//			Restaurant rSaved = ownerDao.addNewRestaurant(restaurantC,m);
//			if (rSaved != null) {
//
//				model.addAttribute("addStatus", "Restaurant Added Successfully!");
//			}
//
//		 else {
//			System.out.println("Failed to create directory!");
//			model.addAttribute("addStatus", "Failed to add restaurant, Please try again!");
//		}
//
			
			return "owner-profile";
			
			

		} catch (Exception e) {

			System.out.println(e.getMessage());
			model.addAttribute("errorMessage", "An error has occurred. Please contact admin");
			return "error";
		}

	}

}

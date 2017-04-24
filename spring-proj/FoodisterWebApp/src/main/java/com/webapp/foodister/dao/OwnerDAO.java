package com.webapp.foodister.dao;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.webapp.foodister.pojo.Menu;
import com.webapp.foodister.pojo.MenuItem;
import com.webapp.foodister.pojo.Owner;
import com.webapp.foodister.pojo.Restaurant;
//import com.webapp.foodister.pojo.User;

public class OwnerDAO extends DAO {

	public OwnerDAO(){
		
	}
	public MenuItem addNewMenuItem(MenuItem mi) throws Exception {
		boolean flag = false;
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");

			

				//if size of list is 0 then user is unique
				getSession().save(mi);
				flag = true;
				transaction.commit();
						//close();
						
					return mi;	
		} catch (HibernateException e) {
			flag = false;
			System.err.println(e.getMessage());
			throw new Exception("Could not add menu item");
		}
		finally{
			close();
		}
	}


	public List<MenuItem> fetchAllMenuItems() throws Exception {
		
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");

			/*
			 String q="";
			if (flag.equalsIgnoreCase("first")) {
                q = "from User where fname= :fname";
            } else if (flag.equalsIgnoreCase("last")) {
                q = "from User where lname= :fname";
            } else if (flag.equalsIgnoreCase("email")) {
                q = "from User where email= :fname";
            }
			Query q1 = getSession().createQuery(q);
			q1.setString("fname", key);		
			List<User> user =q1.list();
			commit();
			return user;
			 */

			Query q = getSession().createQuery("from MenuItem");	
			
			List<MenuItem> menuItems = q.list();
				;
				transaction.commit();
						//close();
						
					return menuItems;	
		} catch (HibernateException e) {
			
			System.err.println(e.getMessage());
			throw new Exception("Could not fetch menu items");
		}
		finally{
			close();
		}
	}
	

	public List<Restaurant> fetchAllRestuarantsForOwner(Owner o) throws Exception {
		
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside fetchAllRestuarantsForOwner DAO");

			/*
			 String q="";
			if (flag.equalsIgnoreCase("first")) {
                q = "from User where fname= :fname";
            } else if (flag.equalsIgnoreCase("last")) {
                q = "from User where lname= :fname";
            } else if (flag.equalsIgnoreCase("email")) {
                q = "from User where email= :fname";
            }
			Query q1 = getSession().createQuery(q);
			q1.setString("fname", key);		
			List<User> user =q1.list();
			commit();
			return user;
			 */

			Query q = getSession().createQuery("from Restaurant where ownedBy = :owner ");	
			q.setEntity("owner", o);
			List<Restaurant> restaurants = q.list();
				
				transaction.commit();
						//close();
						
					return restaurants;	
		} catch (HibernateException e) {
			
			System.err.println(e.getMessage());
			e.printStackTrace();
			
			throw new Exception("Could not fetch restaurants");
		}
		finally{
			close();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//using criteria
	private List<Restaurant> getRestaurantsByCriteria(){
		Transaction transaction = getSession().beginTransaction();

		System.out.println("inside DAO");

		
		Criteria crit = getSession().createCriteria(Restaurant.class);
		Criterion priceLessThan = Restrictions.lt("price", 10.0);
		Criterion tablet = Restrictions.ilike("description", "tablet", MatchMode.ANYWHERE);
		LogicalExpression orExp = Restrictions.or(priceLessThan, tablet);
		crit.add(orExp);
		List<Restaurant> results=crit.list();
		
		return results;
	}
	
	
		
	public MenuItem fetchMenuItemByName(String name) throws Exception{
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");

			
			Query q = getSession().createQuery("from MenuItem where itemName= :name ");	
			q.setString("name", name);
			
			MenuItem menuItem = (MenuItem) q.uniqueResult();
				
				transaction.commit();
						//close();
						
					return menuItem;	
		} catch (HibernateException e) {
			
			System.err.println(e.getMessage());
			throw new Exception("Could not fetch menu item by name");
		}
		finally{
			close();
		}
		
	}
	
	public boolean addNewMenu(Menu menu) throws Exception {
		boolean flag = false;
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");
			getSession().save(menu);
			flag = true;
			transaction.commit();

			
		} catch (HibernateException e) {
			flag = false;
			System.err.println(e.getMessage());
			throw new Exception("Could not add menu");
		}finally{
			close();
		}
		return flag;
	}

	
public List<Menu> fetchAllMenus() throws Exception {
		
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");

			/*
			 String q="";
			if (flag.equalsIgnoreCase("first")) {
                q = "from User where fname= :fname";
            } else if (flag.equalsIgnoreCase("last")) {
                q = "from User where lname= :fname";
            } else if (flag.equalsIgnoreCase("email")) {
                q = "from User where email= :fname";
            }
			Query q1 = getSession().createQuery(q);
			q1.setString("fname", key);		
			List<User> user =q1.list();
			commit();
			return user;
			 */

			Query q = getSession().createQuery("from Menu");	
			
			List<Menu> menus = q.list();
				
				transaction.commit();
						//close();
						
					return menus;	
		} catch (HibernateException e) {
			
			System.err.println(e.getMessage());
			throw new Exception("Could not fetch menu");
		}
		finally{
			close();
		}
	}

public Menu fetchMenuByDescription(String desc, Restaurant r) throws Exception{
	try {
		Transaction transaction = getSession().beginTransaction();

		System.out.println("inside DAO");

		
		Query q = getSession().createQuery("from Menu where description= :desc ");	
		q.setString("desc", desc);
		
		Menu menu = (Menu) q.uniqueResult();
			
		
		System.out.println("printing menu fetched by description" + menu.getId());
		//menu.setRestaurant(r);
		//Menu fromSession = (Menu) getSession().merge(menu);//changed update to merge
		
			transaction.commit();
					//close();
					
		//return fromSession;
			return menu;
	} catch (HibernateException e) {
		
		System.err.println(e.getMessage());
		throw new Exception("Could not fetch menu by desc");
	}
	finally{
		close();
	}

	
	
}



public Restaurant addNewRestaurant(Restaurant r, Menu m) throws Exception {
	boolean flag = false;
	try {
		Transaction transaction = getSession().beginTransaction();

		System.out.println("inside DAO");

			//saving the merged menu

			//Menu fromSession = (Menu) getSession().merge(m);//changed update to merge
		
		
			getSession().saveOrUpdate(m);
		
			
			
			//saving restuarant
			getSession().save(r);
			
			
			flag = true;
			transaction.commit();
					//close();
					
			return r;	
	} catch (HibernateException e) {
		flag = false;
		System.err.println(e.getMessage());
		e.printStackTrace();
		throw new Exception("Could not add restaurant");
	}
	finally{
		close();
	}
}


public boolean updateOwnerProfile(Owner profileOwner) throws Exception {
	boolean flag = false;
	try {
		Transaction transaction = getSession().beginTransaction();

		System.out.println("inside DAO");
		
		
		//String hqlUpdate = "update Owner o set c.name = :newName where c.name = :oldName";
		 String hqlUpdate = "update Owner o set o.firstName = :fName, o.lastName = :lNmame, o.password = :pwd where o.userName = :uName AND o.emailId = :eM";
		int updatedEntities = getSession().createQuery( hqlUpdate )
		        .setString( "fName", profileOwner.getFirstName() )
		        .setString( "lNmame", profileOwner.getLastName() )
		        .setString( "pwd", profileOwner.getPassword() )
		        .setString( "uName", profileOwner.getUserName() )
		        .setString( "eM", profileOwner.getEmailId() )
		        .executeUpdate();

		
		if(updatedEntities > 0)
		{
			flag = true;
			
		}else{
			
			flag = false;
		}
		
		//getSession().save(profileOwner);
		
		//getSession().saveOrUpdate(profileOwner);

		//Owner fromSession = (Owner) getSession().merge(profileOwner);//changed update to merge
		
		
		//getSession().saveOrUpdate(fromSession);

		
		
		
		transaction.commit();

		
	} catch (HibernateException e) {
		flag = false;
		System.err.println(e.getMessage());
		throw new Exception("Could update owner profile");
	}finally{
		close();
	}
	return flag;
}


}

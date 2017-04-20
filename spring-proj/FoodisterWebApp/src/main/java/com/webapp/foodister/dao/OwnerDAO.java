package com.webapp.foodister.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;


import com.webapp.foodister.pojo.MenuItem;
import com.webapp.foodister.pojo.User;

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

}

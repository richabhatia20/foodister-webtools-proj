package com.webapp.foodister.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.webapp.foodister.pojo.Owner;
import com.webapp.foodister.pojo.Restaurant;

public class SearchDAO extends DAO{

	
	public SearchDAO() {
	}

	public List<Restaurant> fetchAllRestuarantsBySearch(String location, String text) throws Exception {
		
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside fetchAllRestuarantsForOwner DAO");

			
			Query q = getSession().createQuery("from Restaurant where city like :location and cuisineType like :text ");	
			q.setString("location", location);
			q.setString("text", text);
			
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

	
	

	
}

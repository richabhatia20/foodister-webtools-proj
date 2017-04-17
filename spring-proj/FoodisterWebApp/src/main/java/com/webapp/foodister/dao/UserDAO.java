package com.webapp.foodister.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.webapp.foodister.pojo.User;


public class UserDAO extends DAO {

	public UserDAO() {
	}
	
	public boolean isUniqueUser(String email, String username) throws Exception{
		boolean flag = false;
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside check unique user");

			Query query = getSession().createQuery("from User where emailId = :email or userName=:username");
			
			query.setString("email", email);
			query.setString("username", username);
			
			ArrayList<User> userList = (ArrayList<User>) query.list();

			if (userList.size() == 0) {

				//email id and username doesnt exist in db so its a unique user
				
				flag = true;
				
			} else {

				flag = false;
			}
			transaction.commit();
			close();
		} catch (HibernateException e) {
			flag = false;
			System.err.println(e.getMessage());
			throw new Exception("Could not query the database");
		}
		return flag;

		
	}
	
	public boolean addNewUSer(User user) throws Exception {
		boolean flag = false;
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");

			ArrayList<User> userListEmail = new ArrayList<User>();
			Query query = getSession().createQuery("from User where emailId = :emailId or userName=:username");
			query.setCacheable(true);
			query.setString("emailId", user.getEmailId());
			query.setString("username", user.getUserName());
			userListEmail = (ArrayList<User>) query.list();

			if (userListEmail.size() == 0) {

				//if size of list is 0 then user is unique
				getSession().save(user);
				flag = true;
				transaction.commit();
			} else {

				flag = false;
			}

			close();
		} catch (HibernateException e) {
			flag = false;
			System.err.println(e.getMessage());
			throw new Exception("Could not add user");
		}
		return flag;
	}
	
	public User checkUserNameAndPassword(String username, String password) throws Exception{
		
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside checkUserNameAndPassword");

			Query query = getSession().createQuery("from User where userName=:username and password = :password");
			
			query.setString("username", username);
			query.setString("password", password);
			
			User user = (User) query.uniqueResult();

			transaction.commit();
			close();
			return user;
		} catch (HibernateException e) {
			
			System.err.println(e.getMessage());
			throw new Exception("Could not query the database");
		}
		

		
	}


}

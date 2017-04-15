package com.webapp.foodister.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.webapp.foodister.pojo.User;


public class UserDAO extends DAO {

	public UserDAO() {
	}
	
	public boolean addNewUSer(User user) throws Exception {
		boolean flag = false;
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");

			ArrayList<User> userListEmail = new ArrayList<User>();
			Query query = getSession().createQuery("from User where email = :emailId or username=:username");
			query.setCacheable(true);
			query.setString("emailId", user.getEmailId());
			query.setString("username", user.getUserName());
			userListEmail = (ArrayList<User>) query.list();

			if (userListEmail.size() == 0) {

				//user.setRole("ROLE_USER");
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

}

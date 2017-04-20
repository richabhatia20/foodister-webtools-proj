package com.webapp.foodister.dao;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import com.webapp.foodister.pojo.Messages;

public class MessageDAO extends DAO {
	
	public MessageDAO()
	{
		
		
	}

	public boolean addNewMessage(Messages m) throws Exception {
		boolean flag = false;
		try {
			Transaction transaction = getSession().beginTransaction();

			System.out.println("inside DAO");
				getSession().save(m);
				flag = true;
				transaction.commit();
				//close();
			
		} catch (HibernateException e) {
			flag = false;
			System.err.println(e.getMessage());
			throw new Exception("Could not add message");
		}
		finally{
			close();
		}
		return flag;
	}

	
	
}

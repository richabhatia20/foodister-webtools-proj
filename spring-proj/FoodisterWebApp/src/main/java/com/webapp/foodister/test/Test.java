//package com.webapp.foodister.test;
//
//import java.util.Date;
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import com.webapp.foodister.pojo.Customer;
////import com.webapp.foodister.pojo.Admin;
////import com.webapp.foodister.pojo.Customer;
//import com.webapp.foodister.pojo.Menu;
//import com.webapp.foodister.pojo.MenuItem;
//import com.webapp.foodister.pojo.Owner;
//import com.webapp.foodister.pojo.Photo;
//import com.webapp.foodister.pojo.Restaurant;
//import com.webapp.foodister.pojo.Review;
////import com.webapp.foodister.pojo.User;
//import com.webapp.foodister.pojo.ReviewReply;
//import com.webapp.foodister.pojo.User;
//
//public class Test {
//
//	public static void main(String[] args) {
//
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session session = sf.openSession();
//		session.beginTransaction();
//
//		Owner tata = new Owner();
//		tata.setFirstName("Ratan");
//		tata.setLastName("Tata");
//		tata.setActive(true);
//		tata.setEmailId("rt@taj.com");
//		tata.setUserName("rt");
//		tata.setPassword("abc");
//		tata.setLastLogin(new Date());
//		
//		Customer c = new Customer();
//		c.setFirstName("Richa");
//		c.setLastName("Bhatia");
//		c.setActive(true);
//		c.setEmailId("rbh@gmail.com");
//		c.setUserName("richa");
//		c.setPassword("abc");
//		c.setLastLogin(new Date());
//		
//		
//		Restaurant res = new Restaurant("Hotel Taj", "Boston");
//		tata.addRestaurant(res);
//		
//		Photo p = new Photo("Pic1", "C:/Images", "description of image");
//		
//		MenuItem mi = new MenuItem("Paneer Tikka", 12.34, "Indian spicy cottage cheese");
//		mi.setItemPhoto(p);
//		
//		Menu menu = new Menu("Indian menu");
//		menu.addMenuItem(mi);
//		
//		res.addMenu(menu);
//		
//		
//		Review rev = new Review("Good", "Enjoyed the food", res, new Date());
//		Photo pRev = new Photo("Pic2", "C:/Images2", "description of image");
//		Photo pRev2 = new Photo("Pic3", "C:/Images3", "description of image");
//		rev.addPhoto(pRev);
//		rev.addPhoto(pRev2);
//		rev.setPostedBy(c);
//		
//		
//		ReviewReply revRep = new ReviewReply("Thanks for your comment", rev, new Date(), tata); 
//		rev.addReviewReply(revRep);
//		
//		res.addReview(rev);
//		
//		
//		session.save(res);
//		
//		
//		Query q=  session.createQuery("from User");
//		List<User> users = q.list();
//		
//		for(User u:users)
//		{
//			System.out.println("printing all users" + u.getFirstName());
//			
//		}
//		
//		session.getTransaction().commit();
//		session.close();
//
//		
//	}
//}

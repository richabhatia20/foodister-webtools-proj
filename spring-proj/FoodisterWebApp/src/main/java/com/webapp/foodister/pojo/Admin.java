package com.webapp.foodister.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.persistence.JoinColumn;

@Entity
@Table(name="ADMIN")
//@PrimaryKeyJoinColumn(name="USER_ID")
public class Admin extends User {
	
//	@OneToMany
//	@JoinTable(
//            name="RESTAURANTS",
//            joinColumns = @JoinColumn( name="RESTAURANT_NAME")
//            
//    )
	@Transient
	private List<Restaurant> listOfRestaurants = new ArrayList<Restaurant>();

	
//	
//	public Admin(String firstName, String lastName, String emailId, String userName, String password,
//			ArrayList<Restaurant> listOfRestaurants) {
//		super(firstName, lastName, emailId, userName, password);
//		this.listOfRestaurants = listOfRestaurants;
//	}

	public Admin() {
		
	}

	public List<Restaurant> getListOfRestaurants() {
		return listOfRestaurants;
	}

	public void setListOfRestaurants(ArrayList<Restaurant> listOfRestaurants) {
		this.listOfRestaurants = listOfRestaurants;
	}
	
	
	

}

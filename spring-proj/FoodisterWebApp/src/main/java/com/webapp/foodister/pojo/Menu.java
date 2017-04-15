package com.webapp.foodister.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name="MENU")

public class Menu {

	@Id
	@GeneratedValue
	@Column(name = "MENU_ID")
	private int id;
	
	@Column(name = "MENU_DESCRIPTION")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MenuItem> itemList = new ArrayList<MenuItem>();
	
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	
	
	public Menu(String description
	//		, ArrayList<MenuItem> itemList
			)
	{
		
		this.description = description;
		//this.itemList = itemList;
	}

	public Menu() {
		
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MenuItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<MenuItem> itemList) {
		this.itemList = itemList;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public void addMenuItem(MenuItem menuItem) {
		itemList.add( menuItem );
		
    }

    public void removeMenuItem(MenuItem menuItem) {
    	itemList.remove( menuItem );
    }

	
}

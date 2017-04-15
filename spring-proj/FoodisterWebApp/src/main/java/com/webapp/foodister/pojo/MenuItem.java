package com.webapp.foodister.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MENUITEM")
public class MenuItem {

	@Id
	@GeneratedValue
	@Column(name = "MENUITEM_ID")
	private int id;
	
	@Column(name = "ITEM_NAME")
	private String itemName;
	
	@Column(name = "ITEM_PRICE")
	private double itemPrice;
	
	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ITEM_PHOTO_ID")
	private Photo itemPhoto;
	
	public MenuItem() {
		
	}

	
	public MenuItem(String itemName, double itemPrice, String itemDescription
			//, Photo itemPhoto
			
			) {
		
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		//this.itemPhoto = itemPhoto;
	}
	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Photo getItemPhoto() {
		return itemPhoto;
	}


	public void setItemPhoto(Photo itemPhoto) {
		this.itemPhoto = itemPhoto;
	}


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	
	
}

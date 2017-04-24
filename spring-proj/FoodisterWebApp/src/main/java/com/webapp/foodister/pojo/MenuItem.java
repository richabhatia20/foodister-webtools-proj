package com.webapp.foodister.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="MENUITEM")
public class MenuItem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "MENUITEM_ID")
	private int id;
	
	@Column(name = "ITEM_NAME")
	private String itemName;
	
	@Column(name = "ITEM_PRICE")
	private double itemPrice;
	
	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;
	
	
	
	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	private String filename;     
	
//	@OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "ITEM_PHOTO_ID")
//	private Photo itemPhoto;
//	
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


//	public Photo getItemPhoto() {
//		return itemPhoto;
//	}
//
//
//	public void setItemPhoto(Photo itemPhoto) {
//		this.itemPhoto = itemPhoto;
//	}


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


	/**
	 * @return the photo
	 */
	public CommonsMultipartFile getPhoto() {
		return photo;
	}


	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}


	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}


	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}

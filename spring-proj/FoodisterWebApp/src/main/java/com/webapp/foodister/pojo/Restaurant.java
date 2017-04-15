package com.webapp.foodister.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name="RESTAURANT")

public class Restaurant {
	
	
	@Id
	@GeneratedValue
	@Column(name = "RESTAURANT_ID")
	private int id;
	
	@Column(name = "RESTAURANT_NAME")
	private String name;
	
	@Column(name = "RESTAURANT_ADDRESS")
	private String address;
	
	@OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Menu menu;
	
	//@OneToMany(mappedBy="review")
	//@Transient
	
	@OneToMany(mappedBy = "postedFor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviewList = new ArrayList<Review>();
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Owner ownedBy;
	
	public Restaurant() {
		
	}

	public Restaurant(String name, String address) {
		
		this.name = name;
		this.address = address;
//		this.menu = menu;
//		this.reviewList = reviewList;
//		this.ownedBy = ownedBy;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}

	
	public Owner getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Owner ownedBy) {
		this.ownedBy = ownedBy;
	}
	
	
	
	public void addMenu(Menu menu) {
        menu.setRestaurant( this );
        this.menu = menu;
    }

    public void removeMenu() {
        if ( menu != null ) {
            menu.setRestaurant( null );
            this.menu = null;
        }
    }
    
    public void addReview(Review review) {
    	reviewList.add( review );
		review.setPostedFor( this );
    }

    public void removeReview(Review review) {
    	reviewList.remove( review );
    	review.setPostedFor( null );
    }
	

}

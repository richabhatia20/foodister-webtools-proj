package com.webapp.foodister.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
//import javax.persistence.Transient;


@Entity
@Table(name="OWNER")
//@PrimaryKeyJoinColumn(name="USER_ID")
public class Owner extends User{

	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	@Column(name = "LASTLOGIN")
	private Date lastLogin;
	
	 @OneToMany(mappedBy = "ownedBy", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Restaurant> restaurantList = new ArrayList<Restaurant>();
	
	 @OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<ReviewReply> repliesToReviews   = new ArrayList<ReviewReply>();;
	
	
	
	
	public Owner() {
		
	}

//
//	public Owner(String firstName, String lastName, String emailId, String userName, String password, boolean isActive,
//			Date lastLogin, ArrayList<Restaurant> restaurantList, ArrayList<ReviewReply> repliesToReviews) {
//		super(firstName, lastName, emailId, userName, password);
//		this.isActive = isActive;
//		this.lastLogin = lastLogin;
//		this.restaurantList = restaurantList;
//		this.repliesToReviews = repliesToReviews;
//	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}
	
	public List<ReviewReply> getRepliesToReviews() {
		return repliesToReviews;
	}
	public void setRepliesToReviews(ArrayList<ReviewReply> repliesToReviews) {
		this.repliesToReviews = repliesToReviews;
	}
	
	public void addRestaurant(Restaurant restaurant) {
		restaurantList.add( restaurant );
		restaurant.setOwnedBy( this );
    }

    public void removeRestaurant(Restaurant restaurant) {
    	restaurantList.remove( restaurant );
    	restaurant.setOwnedBy( null );
    }
	
    public void addReplyToReview(ReviewReply reviewReply) {
    	repliesToReviews.add( reviewReply );
    	reviewReply.setPostedBy( this );
    }

    public void removeReplyToReview(ReviewReply reviewReply) {
    	repliesToReviews.remove( reviewReply );
    	reviewReply.setPostedBy( null );
    }
	
}

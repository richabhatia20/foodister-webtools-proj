package com.webapp.foodister.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Customer extends User{

	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	@Column(name = "LASTLOGIN")
	private Date lastLogin;
	
	@OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviewsWritten  = new ArrayList<Review>();
	
	
	public Customer() {
	
	}


	


	public Customer(String firstName, String lastName, String emailId, String userName, String password
			//,Date lastLogin, 
			//ArrayList<Review> reviewsWritten
			) {
		super(firstName, lastName, emailId, userName, password);
		this.isActive = true;
		//this.lastLogin = lastLogin;
		//this.reviewsWritten = reviewsWritten;
	}





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


	public List<Review> getReviewsWritten() {
		return reviewsWritten;
	}


	public void setReviewsWritten(ArrayList<Review> reviewsWritten) {
		this.reviewsWritten = reviewsWritten;
	}
	
	public void addReview(Review review) {
		reviewsWritten.add( review );
		review.setPostedBy( this );
    }

    public void removeReview(Review review) {
    	reviewsWritten.remove( review );
    	review.setPostedBy( null );
    }
}

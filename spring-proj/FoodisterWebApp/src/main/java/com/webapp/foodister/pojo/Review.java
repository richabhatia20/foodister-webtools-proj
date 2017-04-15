package com.webapp.foodister.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name="REVIEW")

public class Review {

	@Id
	@GeneratedValue
	@Column(name = "REVIEW_ID")
	private int id;
	
	@Column(name = "REVIEW_TITLE")
	private String title;
	
	@Column(name = "REVIEW_COMMENT")
	private String comment;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Customer postedBy;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	//@JoinColumn(name = "RESTAURANT_ID", foreignKey = @ForeignKey(name= "RESTAURANT_ID_FK"))
	private Restaurant postedFor;
	
	@Column(name = "REVIEW_DATE")
	private Date postedOn;
		
	@OneToOne(mappedBy = "replyFor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private ReviewReply reviewReply;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Photo> reviewPhotos = new ArrayList<Photo>();

	public Review() {
		
	}

	
	

	public Review(String title, 
			String comment, 
			//Customer postedBy, 
			Restaurant postedFor, 
			Date postedOn
			//ReviewReply reviewReply, 
			//ArrayList<Photo> reviewPhotos
			) {
		
		this.title = title;
		this.comment = comment;
		//this.postedBy = postedBy;
		this.postedFor = postedFor;
		this.postedOn = postedOn;
		//this.reviewReply = reviewReply;
		//this.reviewPhotos = reviewPhotos;
	}

	


	public List<Photo> getReviewPhotos() {
		return reviewPhotos;
	}




	public void setReviewPhotos(ArrayList<Photo> reviewPhotos) {
		this.reviewPhotos = reviewPhotos;
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Customer getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(Customer postedBy) {
		this.postedBy = postedBy;
	}


	public Restaurant getPostedFor() {
		return postedFor;
	}


	public void setPostedFor(Restaurant postedFor) {
		this.postedFor = postedFor;
	}


	public Date getPostedOn() {
		return postedOn;
	}


	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}


	public ReviewReply getReviewReply() {
		return reviewReply;
	}


	public void setReviewReply(ReviewReply reviewReply) {
		this.reviewReply = reviewReply;
	}

	public void addReviewReply(ReviewReply reviewReply) {
		reviewReply.setReplyFor( this );
        this.reviewReply = reviewReply;
    }

    public void removeReviewReply() {
        if ( reviewReply != null ) {
        	reviewReply.setReplyFor( null );
            this.reviewReply = null;
        }
    }
    
    public void addPhoto(Photo photo) {
    	reviewPhotos.add( photo );
		
    }

    public void removePhoto(Photo photo) {
    	reviewPhotos.remove( photo );
    }


}

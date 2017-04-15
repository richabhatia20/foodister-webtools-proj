package com.webapp.foodister.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name="REVIEW_REPLY")
public class ReviewReply {

	@Id
	@GeneratedValue
	@Column(name = "REVIEW_REPLY_ID")
	private int id;
	
	@Column(name = "REVIEW_REPLY_COMMENT")
	private String comment;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "REVIEW_ID")
	private Review replyFor;
	
	@Column(name = "REVIEW_REPLY_DATE")
	private Date postedOn;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Owner postedBy;
	
	public ReviewReply(String comment, Review replyFor, Date postedOn, Owner postedBy
			) {
		
		this.comment = comment;
		this.replyFor = replyFor;
		this.postedOn = postedOn;
		this.postedBy = postedBy;
	}

	public ReviewReply() {
		
	}
	

	public Owner getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Owner postedBy) {
		this.postedBy = postedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Review getReplyFor() {
		return replyFor;
	}

	public void setReplyFor(Review replyFor) {
		this.replyFor = replyFor;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	
	
	
}

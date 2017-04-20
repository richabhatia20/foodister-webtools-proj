package com.webapp.foodister.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGES")

public class Messages {

	@Id
	@GeneratedValue
	@Column(name = "MESSAGE_ID")
	private int id;
	
	@Column(name = "MESSAGE_NAME")
	private String name;

	@Column(name = "MESSAGE_EMAIL")
	private String email;
	
	@Column(name = "MESSAGE_TEXT")
	private String message;

	public Messages(String name, String email, String message) {
		
		this.name = name;
		this.email = email;
		this.message = message;
	}

	public Messages() {
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

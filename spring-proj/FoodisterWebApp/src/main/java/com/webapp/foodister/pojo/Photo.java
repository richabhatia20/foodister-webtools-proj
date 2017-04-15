package com.webapp.foodister.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PHOTO")
public class Photo {
	
	@Id
	@GeneratedValue
	@Column(name = "PHOTO_ID")
	private int id;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "FILE_PATH")
	private String filePath;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public Photo(String fileName, String filePath, String description) {
			
		this.fileName = fileName;
		this.filePath = filePath;
		this.description = description;
	}
	
	public Photo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

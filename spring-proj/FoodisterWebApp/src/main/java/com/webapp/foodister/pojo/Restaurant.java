package com.webapp.foodister.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name = "RESTAURANT")

public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "RESTAURANT_ID")
	private int id;

	@Column(name = "RESTAURANT_NAME")
	private String name;

	@Column(name = "RESTAURANT_ADDRESS")
	private String address;

	@Column(name = "RESTAURANT_CITY")
	private String city;

	@Column(name = "RESTAURANT_CUISINE")
	private String cuisineType;
	
	@Column(name = "RESTAURANT_RATING")
	private int rating;
	
	@Column(name = "RESTAURANT_TIMINGS")
	private String timings;
	
	@OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Menu menu;

	// @OneToMany(mappedBy="review")
	// @Transient

	@OneToMany(mappedBy = "postedFor", cascade = CascadeType.ALL)
	private List<Review> reviewList = new ArrayList<Review>();

	@ManyToOne(cascade = { CascadeType.ALL })
	private Owner ownedBy;

	public Restaurant() {

	}

	public Restaurant(String name, String address, String city, String cuisineType) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.cuisineType = cuisineType;
		this.rating = calcFinalRatings(reviewList);
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

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public Owner getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Owner ownedBy) {
		this.ownedBy = ownedBy;
	}

	public void addMenu(Menu menu) {
		menu.setRestaurant(this);
		this.menu = menu;
	}

	public void removeMenu() {
		if (menu != null) {
			menu.setRestaurant(null);
			this.menu = null;
		}
	}

	public void addReview(Review review) {
		reviewList.add(review);
		review.setPostedFor(this);
	}

	public void removeReview(Review review) {
		reviewList.remove(review);
		review.setPostedFor(null);
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the cuisineType
	 */
	public String getCuisineType() {
		return cuisineType;
	}

	/**
	 * @param cuisineType
	 *            the cuisineType to set
	 */
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}
	
	public int calcFinalRatings(List<Review> reviewList)
	{
		int finalRating =0;
		try{
			int temp=0;
			for(Review r: reviewList){
				
				 temp += r.getReviewRating();
			}
			
			finalRating = (temp/reviewList.size());
			
		}catch(Exception e){
			finalRating =0;
			System.out.println("exception in calculating ratings");
			e.printStackTrace();
			
		}
		finally{
		return finalRating;
		}
	}

}

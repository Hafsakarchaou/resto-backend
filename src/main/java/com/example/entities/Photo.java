package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String url;
	
	@ManyToOne
	@JsonIgnore
	private Restaurant restaurant;

	public Photo() {
		super();
	}



	public Photo(String url) {
		super();
		this.url = url;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public Restaurant getRestaurant() {
		return restaurant;
	}



	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}

	
	
}

package com.example.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany
	private List<Restaurant> restaurants;
	
	public Specialite() {
		super();
	}



	public Specialite(String nom) {
		super();
		this.nom = nom;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}



	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}


}

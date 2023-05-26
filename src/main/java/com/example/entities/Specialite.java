package com.example.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany(mappedBy = "specialites",fetch = FetchType.EAGER)
	private List <Restaurant>restaurants;
	
	
	public Specialite() {
		super();
	}

	public Specialite(String nom, List<Restaurant> restaurants) {
		super();
		this.nom = nom;
		this.restaurants = restaurants;
	}

    public Specialite(int id) {
        this.id = id;
    }



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public List<Restaurant> getRestaurants() {
	    if (restaurants == null) {
	        restaurants = new ArrayList<>();
	    }
	    return restaurants;
	}


	public void setRestaurants(List<Restaurant> restaurants) {
	    if (this.restaurants == null) {
	        this.restaurants = new ArrayList<>();
	    }
	    this.restaurants.addAll(restaurants);
	}




	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



}

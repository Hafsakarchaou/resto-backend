package com.example.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Zone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	
	@ManyToOne
	@JoinColumn(name="id_ville")
	@JsonIgnoreProperties("zones")
	private Ville ville;
	
	
	@OneToMany(mappedBy = "zone")
	private List<Restaurant> Restaurants;
	
	public Zone() {
		super();
	}



	public Zone(String nom) {
		super();
		this.nom = nom;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Ville getVille() {
		return ville;
	}



	public void setVille(Ville ville) {
		this.ville = ville;
	}



	public List<Restaurant> getRestaurants() {
		return Restaurants;
	}



	public void setRestaurants(List<Restaurant> restaurants) {
		Restaurants = restaurants;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	
}

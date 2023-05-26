package com.example.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(mappedBy = "ville")
	private List<Zone> zones;

	public Ville() {
		super();
	}



	public Ville(String nom) {
		super();
		this.nom = nom;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public List<Zone> getZones() {
		return zones;
	}



	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}
}

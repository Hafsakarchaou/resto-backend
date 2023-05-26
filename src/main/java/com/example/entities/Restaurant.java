package com.example.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private Double longitude;
	private Double latitude;
	private String ran__;
	@Column(name = "heure_ouverture")
	@Temporal(TemporalType.TIME)
	private Time heure_ouverture;

	@Column(name = "heure_fermeture")
	@Temporal(TemporalType.TIME)
	private Time heure_fermeture;
	
	
	
	
	@ManyToOne
	@JsonIgnoreProperties("restaurants")
	@JoinColumn(name = "zone_id")
	private Zone zone;
	
	
	@ManyToOne
	@JsonIgnoreProperties("restaurants")
	@JoinColumn(name="serie_id")
	private Serie serie;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	    joinColumns = {
	            @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
	    },
	    inverseJoinColumns = {
	            @JoinColumn(name = "specialite_id", referencedColumnName = "id")
	    }
	)
	@JsonIgnoreProperties("restaurants")
	private List<Specialite> specialites;
	
	@ManyToMany(mappedBy = "restaurants", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<User> users;
	

	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Photo> photos;
	
	
	
	public String getRan__() {
		return ran__;
	}

	public void setRan__(String ran__) {
		this.ran__ = ran__;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
	    this.specialites = specialites;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getRange() {
		return ran__;
	}

	public void setRange(String range) {
		this.ran__ = range;
	}

	public Time getHeure_ouverture() {
		return heure_ouverture;
	}

	public void setHeure_ouverture(Time heure_ouverture) {
		this.heure_ouverture = heure_ouverture;
	}

	public Time getHeure_fermeture() {
		return heure_fermeture;
	}

	public void setHeure_fermeture(Time heure_fermeture) {
		this.heure_fermeture = heure_fermeture;
	}

	public Restaurant(String nom, String adresse, Double longitude, Double latitude, String range, Time heure_ouverture,
	        Time heure_fermeture, List<Specialite> specialites) {
	    super();
	    this.nom = nom;
	    this.adresse = adresse;
	    this.longitude = longitude;
	    this.latitude = latitude;
	    this.ran__ = range;
	    this.heure_ouverture = heure_ouverture;
	    this.heure_fermeture = heure_fermeture;
	    if (specialites != null) {
	        this.specialites = specialites;
	    } else {
	        this.specialites = new ArrayList<>();
	    }
	}

	public Restaurant() {
		super();
	}
	
	
}

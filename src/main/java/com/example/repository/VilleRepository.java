package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Restaurant;
import com.example.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville,Integer>{

	Ville findById(int id);
	
	
	Ville findByNom(String nom);

}

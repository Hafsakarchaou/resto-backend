package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone,Integer>{
	
	Zone findById(int id);
	Zone findByNom(String nom);
	
	
}

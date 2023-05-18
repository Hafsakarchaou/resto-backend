package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Restaurant;
import com.example.entities.Specialite;
import com.example.entities.Zone;

public interface SpecialiteRepository extends JpaRepository<Specialite,Integer> {

	Specialite findById(int id);
	Specialite findByNom(String nom);
}

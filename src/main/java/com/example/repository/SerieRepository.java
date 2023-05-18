package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Serie;

public interface SerieRepository extends JpaRepository<Serie,Integer> {

	//@Query ("SELECT s from specialite s WHERE s.nom=?1 ")
	//Serie  findSpecialiteByNom(String nom);
	Serie findById(int id);
	Serie findByNom(String nom);
}


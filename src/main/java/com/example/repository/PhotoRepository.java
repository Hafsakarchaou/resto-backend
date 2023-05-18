package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	
Photo findById(int id);
	
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Serie;
import com.example.repository.SerieRepository;

import Dao.IDao;

@Service

public class SerieService implements IDao<Serie>{

	
	@Autowired
	private SerieRepository serieRepository;
	@Override
	public Serie save(Serie o) {
		
		return serieRepository.save(o);
	}

	@Override
	public List<Serie> findAll() {
		
		return serieRepository.findAll();	}

	

	@Override
	public void update(String id,Serie o) {
		serieRepository.save(serieRepository.findById(Integer.parseInt(id)));
		
	}

	@Override
	public void delete(String id) {
		
		serieRepository.deleteById(Integer.parseInt(id));
	}

	@Override
	public Serie findById(String id) {
		return 	 serieRepository.findById(Integer.parseInt(id));
	}

}

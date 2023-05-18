package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Specialite;
import com.example.repository.SpecialiteRepository;
import Dao.IDao;


@Service
public class SpecialiteService implements IDao<Specialite>{

	@Autowired
	private SpecialiteRepository specialiteRepository;
	

	
	@Override
	public Specialite save(Specialite o) {
		
		return specialiteRepository.save(o);
	}

	@Override
	public List<Specialite> findAll() {
		return specialiteRepository.findAll();
	}

	@Override
	public Specialite findById(String id) {
		
		return specialiteRepository.findById(Integer.parseInt(id));
	}

	@Override
	public void update(String id,Specialite o) {
		specialiteRepository.save(specialiteRepository.findById(Integer.parseInt(id)));
		
	}

	@Override
	public void delete(String id) {
		specialiteRepository.deleteById(Integer.parseInt(id));
		
	}

}

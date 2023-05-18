package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Zone;

import com.example.repository.ZoneRepository;

import Dao.IDao;


@Service
public class ZoneService implements IDao<Zone>{

	@Autowired
	private ZoneRepository zoneRepository;
	@Override
	public Zone save(Zone o) {
		
		return zoneRepository.save(o);
	}

	@Override
	public List<Zone> findAll() {
		
		return zoneRepository.findAll();
	}

	@Override
	public Zone findById(String id) {
		// TODO Auto-generated method stub
		return zoneRepository.findById(Integer.parseInt(id));
	}

	@Override
	public void update(String id,Zone o) {
		
		zoneRepository.save(zoneRepository.findById(Integer.parseInt(id)));
	}

	@Override
	public void delete(String id) {
		 zoneRepository.deleteById(Integer.parseInt(id));
		
	}

	public Zone findByNom(String nom) {
		return zoneRepository.findByNom(nom);
	}

	

}

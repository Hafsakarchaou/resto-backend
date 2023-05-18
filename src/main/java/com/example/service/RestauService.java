package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Restaurant;

import com.example.repository.RestauRepository;

import Dao.IDao;

@Service
public class RestauService implements IDao<Restaurant>{

	@Autowired
	private RestauRepository restauRepository ;
	
	
	
	/*public List<Restaurant> findBySpecialiteEqualsAndZoneEquals(String nomSpecialite,String nomZone) {
		return restauRepository.findBySpecialiteEqualsAndZoneEquals(nomSpecialite, nomZone);
	}*/

	@Override
	public Restaurant save(Restaurant o) {
		return restauRepository.save(o);
		
	}

	@Override
	public List<Restaurant> findAll() {
		return restauRepository.findAll();
		
	}

	@Override
	public Restaurant findById(String id) {
		return restauRepository.findById(Integer.parseInt(id));
	}

	@Override
	public void update(String id,Restaurant o) {
		 restauRepository.save(restauRepository.findById(Integer.parseInt(id)));
		
	}

	@Override
	public void delete(String id) {
		restauRepository.deleteById(Integer.parseInt(id));
		
	}


}

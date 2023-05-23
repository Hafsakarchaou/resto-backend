package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Restaurant;
import com.example.entities.Specialite;
import com.example.repository.RestauRepository;
import com.example.repository.SpecialiteRepository;

import Dao.IDao;
import jakarta.transaction.Transactional;

@Service
public class RestauService implements IDao<Restaurant>{

	@Autowired
	private RestauRepository restauRepository ;
	private SpecialiteRepository specialiteRepository ;
	
	
	
	/*public List<Restaurant> findBySpecialiteEqualsAndZoneEquals(String nomSpecialite,String nomZone) {
		return restauRepository.findBySpecialiteEqualsAndZoneEquals(nomSpecialite, nomZone);
	}*/

	
	@Override
	@Transactional
	public Restaurant save(Restaurant o) {
		for (Specialite specialite : o.getSpecialites()) {
	        specialite.getRestaurants().add(o);
	    }
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

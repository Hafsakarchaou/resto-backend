package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Photo;
import com.example.repository.PhotoRepository;

import Dao.IDao;

@Service
public class PhotoService implements IDao<Photo>{

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public Photo save(Photo o) {
		
		return photoRepository.save(o);
	}

	@Override
	public List<Photo> findAll() {
		// TODO Auto-generated method stub
		return photoRepository.findAll();
	}

	@Override
	public Photo findById(String id) {
		// TODO Auto-generated method stub
		return photoRepository.findById(Integer.parseInt(id));
	}

	@Override
	public void update(String id, Photo o) {
		// TODO Auto-generated method stub
		photoRepository.save(photoRepository.findById(Integer.parseInt(id)));
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		photoRepository.deleteById(Integer.parseInt(id));
	}

}

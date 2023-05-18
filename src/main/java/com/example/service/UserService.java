package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repository.UserRepository;

import Dao.IDao;

@Service
public class UserService implements IDao<User>{

	@Autowired
	private UserRepository userRepository;
	@Override
	public User save(User o) {
		// TODO Auto-generated method stub
		return userRepository.save(o);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(Integer.parseInt(id));
	}

	@Override
	public void update(String id,User o) {
		// TODO Auto-generated method stub
		userRepository.save( userRepository.findById(Integer.parseInt(id)));
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(Integer.parseInt(id));
		
	}



}

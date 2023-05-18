package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Role;
import com.example.repository.RoleRepository;

import Dao.IDao;
@Service
public class RoleService implements IDao<Role> {

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Role save(Role o) {
		// TODO Auto-generated method stub
		return roleRepository.save(o);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role findById(String id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(Integer.parseInt(id));
	}

	@Override
	public void update(String id, Role o) {
		// TODO Auto-generated method stub
		roleRepository.save(roleRepository.findById(Integer.parseInt(id)));
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(Integer.parseInt(id));
	}

}

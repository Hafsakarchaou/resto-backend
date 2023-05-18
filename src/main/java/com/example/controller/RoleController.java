package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Role;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleService roleService;

	@PostMapping("/save")
	public void save(@RequestBody Role r) {
		roleService.save(r);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		roleService.delete(id);
	}

	@GetMapping("/all")
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@PostMapping("/update")
	public void update(@PathVariable String id,@RequestBody Role r){
		roleService.update(id,r);
	}

	@GetMapping("/{id}")
	public Role findById(String id) {
		return roleService.findById(id);
	}
	


}

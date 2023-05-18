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

import com.example.entities.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/save")
	public void save(@RequestBody User s){
		userService.save(s);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		userService.delete(id);
	}

	@GetMapping("/all")
	public List<User> findAll(){
	return userService.findAll();
	}


	@PostMapping("/update")
	public void update(@PathVariable String id,@RequestBody User s){
		userService.update(id,s);
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable String id) {
		return userService.findById(id);
	}
}

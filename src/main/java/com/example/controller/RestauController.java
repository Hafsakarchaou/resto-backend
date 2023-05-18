package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Photo;
import com.example.entities.Restaurant;
import com.example.service.RestauService;
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("restaurants")
public class RestauController {
	@Autowired
	private RestauService restoService;
	
	@PostMapping("/save")
	public void save(@RequestBody Restaurant restaurant){
		restoService.save(restaurant);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
	restoService.delete(id);
	}
	
	@GetMapping("/all")
	public List<Restaurant> findAll(){
	return restoService.findAll();
	}
	
	
	@GetMapping("/update")
	public void update(@PathVariable String id,@RequestBody Restaurant restaurant){
		restoService.update(id, restaurant);
	}
	
	@GetMapping("/{id}")
	public Restaurant findById(@PathVariable String id) {
		return restoService.findById(id);
	}
	/**/

}
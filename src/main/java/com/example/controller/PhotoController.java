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
import com.example.repository.PhotoRepository;
import com.example.service.PhotoService;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("photos")
public class PhotoController {

	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private PhotoService photoService;
	
	@PostMapping("/save")
	public void save(@RequestBody Photo s){
		photoService.save(s);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		photoService.delete(id);
	}

	@GetMapping("/all")
	public List<Photo> findAll(){
	return photoService.findAll();
	}


	@PostMapping("/update")
	public void update(@PathVariable String id,@RequestBody Photo s){
		photoService.update(id,s);
	}

	@GetMapping("/{id}")
	public Photo findById(@PathVariable String id) {
		return photoService.findById(id);
	}
	
	
}

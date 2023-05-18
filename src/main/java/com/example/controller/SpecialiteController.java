package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entities.Restaurant;
import com.example.entities.Specialite;
import com.example.entities.Zone;
import com.example.repository.SpecialiteRepository;
import com.example.service.SpecialiteService;


@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("specialites")
public class SpecialiteController {

	@Autowired
	private SpecialiteRepository specialiteRepository;
	@Autowired
	private SpecialiteService specialiteService;
	
	
	@PostMapping("/save")
	public void save(@RequestBody Specialite s){
		specialiteService.save(s);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		specialiteService.delete(id);
	}

	@GetMapping("/all")
	public List<Specialite> findAll(){
	return specialiteService.findAll();
	}


	/*@PostMapping("/update/{id}")
	public void update(@PathVariable String id,@RequestBody Specialite s){
		specialiteService.update(id,s);
	}*/
	@PutMapping("/update/{id}")
    public Specialite update(@PathVariable String id, @RequestBody Specialite s) {
        Specialite existingSpecialite = specialiteService.findById(id);
        if (existingSpecialite != null) {
        	existingSpecialite.setNom(s.getNom());
            return specialiteService.save(existingSpecialite);
        }
        return null;
    }


	@GetMapping("/{id}")
	public Specialite findById(@PathVariable String id) {
		return specialiteService.findById(id);
	}
	
	
}

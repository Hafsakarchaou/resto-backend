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

import com.example.entities.Ville;
import com.example.entities.Zone;
import com.example.repository.ZoneRepository;
import com.example.service.ZoneService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("zones")
public class ZoneController {
	@Autowired
	private ZoneRepository zoneRepository;
	
	@Autowired
	private ZoneService zoneService;
	


	@PostMapping("/save")
	public void save(@RequestBody Zone zone){
		zoneService.save(zone);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		zoneService.delete(id);
	}

	@GetMapping("/all")
	public List<Zone> findAll(){
	return zoneService.findAll();
	}


	@PutMapping("/update/{id}")
	public Zone updateZone(@PathVariable String id, @RequestBody Zone zone) {
		
		zone.setId(Integer.parseInt(id));
		return zoneService.save(zone);
	}

	@GetMapping("/{id}")
	public Zone findById(@PathVariable String id) {
		return zoneService.findById(id);
	}

}

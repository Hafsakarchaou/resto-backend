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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Serie;
import com.example.entities.Specialite;
import com.example.repository.SerieRepository;
import com.example.service.SerieService;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("series")
public class SerieController {

	@Autowired
	private SerieRepository serieRepository;
	@Autowired
	private SerieService serieService;
	
	@PostMapping("/save")
	public void save(@RequestBody Serie s){
		serieService.save(s);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		serieService.delete(id);
	}

	@GetMapping("/all")
	public List<Serie> findAll(){
	return serieService.findAll();
	}


	@PutMapping("/update/{id}")
	public Serie update(@PathVariable String id, @RequestBody Serie s) {
        Serie existingSerie = serieService.findById(id);
        if (existingSerie != null) {
        	existingSerie.setNom(s.getNom());
            return serieService.save(existingSerie);
        }
        return null;
    }


	@GetMapping("/{id}")
	public Serie findById(@PathVariable String id) {
		return serieService.findById(id);
	}
	
	/**/
}

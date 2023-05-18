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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Restaurant;
import com.example.entities.Specialite;
import com.example.entities.Ville;
import com.example.entities.Zone;
import com.example.repository.VilleRepository;
import com.example.service.VilleService;
import com.example.service.ZoneService;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("villes")

public class VilleController {
@Autowired
private VilleRepository villeRepository;

@Autowired
private VilleService villeService;

@Autowired
private ZoneService zoneService;



@PostMapping("/save")
public void save(@RequestBody Ville ville){
	villeService.save(ville);
}
@GetMapping("/{id}")
public Ville findById(@PathVariable String id) {
	return villeService.findById(id);
}


@DeleteMapping("/delete/{id}")
public void delete(@PathVariable (required = true) String id){
villeService.delete(id);
}


@GetMapping("/all")
public List<Ville> findAll(){
return villeService.findAll();
}


@PutMapping("/update/{id}")
public Ville update(@PathVariable String id, @RequestBody Ville ville){
	Ville existingVille = villeService.findById(id);
    if (existingVille != null) {
    	existingVille.setNom(ville.getNom());
        return villeService.save(existingVille);
    }
	return existingVille;
}
  


@GetMapping("/{nom}/zones")
public List<Zone> findByVille(@PathVariable String nom) {
	return villeService.findByVille(nom);
}


@GetMapping("/{ville}/zones/{zone}/restaurants")
public List<Restaurant> restoParZone(@PathVariable String ville, @PathVariable String zone) {
	return villeService.restoParZone(ville, zone);
}

@GetMapping("/{ville}/zones/{zone}/restaurants&specialite={specialite}")
public List<Restaurant> getRestaurantsBySpeciality(@PathVariable String ville, @PathVariable String zone, @PathVariable String specialite)
{
    
    return villeService.restoParSpecialite(ville, zone, specialite);
}


/*@GetMapping("/{ville}/zones/{zone}/restaurants?specialite={specialite}")
public List<Restaurant> getRestaurantsByZoneAndSpecialite(
        @PathVariable String ville,
        @PathVariable String zone,
        @RequestParam(required = false) String specialite) {
    return villeService.getRestaurantsByZoneAndSpecialite(ville, zone, specialite);
}
*/


@GetMapping("/{ville}/zones/{zone}/restaurants&serie={serie}")
public List<Restaurant> restoParChaine(@PathVariable String ville, @PathVariable String zone, @PathVariable String serie) {
	return villeService.restoParChaine(ville, zone, serie);
}










}

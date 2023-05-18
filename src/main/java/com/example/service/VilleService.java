package com.example.service;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Restaurant;
import com.example.entities.Serie;
import com.example.entities.Ville;
import com.example.entities.Zone;
import com.example.entities.Specialite;
import com.example.repository.RestauRepository;
import com.example.repository.SerieRepository;
import com.example.repository.SpecialiteRepository;
import com.example.repository.VilleRepository;
import com.example.repository.ZoneRepository;

import Dao.IDao;
@Service
public class VilleService implements IDao<Ville>{

	@Autowired
	private ZoneRepository zoneRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private RestauService restauService;
	
	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	@Autowired
	private SerieRepository serieRepository;
	
	@Autowired
	private RestauRepository restauRepository;
	
	/*public List<Restaurant> findBySpecialiteEqualsAndZoneEquals(String nomSpecialite,String nomZone) {
		return restauService.findBySpecialiteEqualsAndZoneEquals(nomSpecialite,nomZone);
	}*/

	@Override
	public Ville save(Ville o) {
		return villeRepository.save(o);
	}

	@Override
	public List<Ville> findAll() {
		// TODO Auto-generated method stub
		return villeRepository.findAll();
	}

	@Override
	public Ville findById(String id) {
		
		return villeRepository.findById(Integer.parseInt(id));
	}

	@Override
	public void update(String id ,Ville o) {
		
		villeRepository.save(villeRepository.findById(Integer.parseInt(id)));
	}

	@Override
	public void delete(String id) {
		villeRepository.deleteById(Integer.parseInt(id));
		
	}

	public Ville findByNom(String nom) {
		return villeRepository.findByNom(nom);
	}
	

	public List<Zone> findByVille(String nom){
		Ville ville=villeRepository.findByNom(nom);
		return ville.getZones();
	}
	
	

	public List<Restaurant> restoParZone (String nomV,String nomZ){
		
		Ville ville=villeRepository.findByNom(nomV);
		
		Zone zone=zoneRepository.findByNom(nomZ);
		
		List<Zone> zonesByVille=ville.getZones();
		
		for(Zone z:zonesByVille) {
			if (z.equals(zone)) {
				return z.getRestaurants();}
		}
		
		return null;
	}
	///////
	

	/////
	
	/*public List<Restaurant> getRestaurantsByZoneAndSpecialite(String ville, String zone, String specialite) 
	{

List<Restaurant> restaurants = restauRepository.findByZoneVilleNomAndZoneNomAndSpecialitesNom(zone, specialite, ville);
return restaurants;
}*/

	/*public List<Restaurant> getRestaurantsByVilleAndZoneAndSpecialite(String ville, String zone, String specialite) {
        return restauRepository.findByZoneVilleAndZoneNomAndSpecialitesNom(ville, zone, specialite);
    }*/
	
    /*public List<Restaurant> getRestaurantsBySpeciality(String ville, String zone, String specialite) {
    	return restauRepository.findByZoneVilleNomAndZoneNomAndSpecialitesNom(ville, zone, specialite);

    }*/
	
	


	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Restaurant> restoParSpecialite(String nomV, String nomZ, String nomS) {
        Ville ville = villeRepository.findByNom(nomV);
        Zone zone = zoneRepository.findByNom(nomZ);
        Specialite specialite = specialiteRepository.findByNom(nomS);
        
        List<Restaurant> restaurantsFound = restauRepository.findByZoneAndSpecialites(zone, specialite);
        List<Restaurant> restaurants = new ArrayList<>();

        for (Restaurant r : restaurantsFound) {
            if (r.getZone().getVille().equals(ville)) {
                restaurants.add(r);
            }
        }
        
        return restaurants;
    }
	
		
		

	public List<Restaurant> restoParChaine (String ville,String zone,String serie ){
		Ville v=villeRepository.findByNom(ville);
		
		Zone z=zoneRepository.findByNom(zone);
		
		Serie s=serieRepository.findByNom(serie);
		
		List<Restaurant> restaurants = new ArrayList<>();
		
		List<Restaurant> restaurantsFound = restauRepository.findByZoneAndSerie(z, s);
		
		for (Restaurant r : restaurantsFound) {
            if (r.getZone().getVille().equals(v)) {
                restaurants.add(r);
            }
        }
        
        return restaurants;

		
	}
	

    /*@GetMapping("/location")
    public List<Itinerary> getItineraryByLocation(@RequestParam Double longitude, @RequestParam Double latitude) {
        // Call a service or repository to retrieve the itineraries based on the given longitude and latitude
        List<Itinerary> itineraries = itineraryService.getItineraryByLocation(longitude, latitude);

        // Return the itineraries
        return itineraries;
    }*/
	
}

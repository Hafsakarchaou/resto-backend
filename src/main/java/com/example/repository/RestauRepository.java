package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Restaurant;
import com.example.entities.Zone;
import com.example.entities.Specialite;
import com.example.entities.Serie;
@Repository
public interface RestauRepository extends JpaRepository<Restaurant,Integer>{
	
	Restaurant findById(int id);
	//List<Restaurant> findBySpecialiteEqualsAndZoneEquals(String nomSpecialite,String nomZone);
	
	@Query(value = "select r from restaurant r where r.serie_id= :serie_id", nativeQuery = true)
	List<Restaurant> FindBySeri(@Param("serie_id") int serie_id);
	
	//List<Restaurant> findByZoneVilleNomAndZoneNomAndSpecialitesNom(String ville, String zone, String specialite);
	List<Restaurant> findByZoneAndSpecialites(Zone zone, Specialite specialite);
	List<Restaurant> findByZoneAndSerie(Zone zone, Serie serie);
	
    /*@Query("SELECT r FROM Restaurant r "
            + "JOIN r.zone z "
            + "JOIN z.ville v "
            + "JOIN r.specialites s "
            + "WHERE s.nom = :specialiteNom "
            + "AND v.nom = :villeNom "
            + "AND z.nom = :zoneNom")
    List<Restaurant> findByZoneVilleNomAndZoneNomAndSpecialitesNom(
            @Param("specialiteNom") String specialiteNom,
            @Param("villeNom") String villeNom,
            @Param("zoneNom") String zoneNom);*/

	//List<Restaurant> findRestaurantsBySpecialitesNomAndZoneVilleNomAndZoneNom(String specialityName, String cityName, String zoneName);
	//List<Restaurant> findByVilleAndZoneAndSpecialite(String ville, String zone, String specialite);
	    


}

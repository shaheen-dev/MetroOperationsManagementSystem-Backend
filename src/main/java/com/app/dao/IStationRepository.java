package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Station;
import com.app.pojos.TripDetails;

@Repository
public interface IStationRepository extends JpaRepository<Station, Integer> {

	//public Station findByName(String name);
	
	@Query("select s.id from Station s where s.name=:name123")
	public int getStationId(@Param("name123") String name);
	
	public Station getStationById(int id);
}

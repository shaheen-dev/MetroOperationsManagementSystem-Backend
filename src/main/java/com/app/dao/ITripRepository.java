package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Trip;

@Repository
public interface ITripRepository extends JpaRepository<Trip, Integer> {

	@Query("select tr from Trip tr join fetch tr.train t where t.id=:trpID")
	public Trip getTrainNoByTripId(@Param("trpID") int trpId);
	
	@Query("select t.end from Trip t where t.id=:trpID")
	public String getTowardsStationName(@Param("trpID") int trpId);
	
}

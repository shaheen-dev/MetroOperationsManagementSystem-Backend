package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.TripDetails;

@Repository
public interface ITripDetailsRepository extends JpaRepository<TripDetails, Integer> {

	@Query("select tr from TripDetails tr where tr.sId=:id")
	public List<TripDetails> getScheduleById(@Param("id") int id);
	
	
}

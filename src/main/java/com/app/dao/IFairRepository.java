package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Fair;

@Repository
public interface IFairRepository extends JpaRepository<Fair, Integer> {

	//public Fair findBySourceAndDestination(int src,int dest);
	
	@Query("select f.amount from Fair f where source=:src and destination=:dest")
	public int getFairAmount(@Param("src") int src, @Param("dest") int dest);
	
	@Query("select f from Fair f where f.source=:src")
	public List<Fair> getFairFromStation(@Param("src") int src);

}

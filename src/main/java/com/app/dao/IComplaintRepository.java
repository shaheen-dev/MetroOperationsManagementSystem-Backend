package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Complaints;

@Repository
public interface IComplaintRepository extends JpaRepository<Complaints, Integer> {

	public List<Complaints> findByEmail(String email);

	@Query("select count(t) from Complaints t where t.status=false")
	public int getAllPendingComplaints();
	
}

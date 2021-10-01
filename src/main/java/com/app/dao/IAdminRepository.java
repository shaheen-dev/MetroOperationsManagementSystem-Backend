package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

	
	Optional<Admin> findByEmailAndPassword(String email, String pass);

}

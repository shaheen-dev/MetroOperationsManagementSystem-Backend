package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	

	public Optional<User> findByEmailAndPassword(String email, String pass);

	public User findByEmail(String string);
}

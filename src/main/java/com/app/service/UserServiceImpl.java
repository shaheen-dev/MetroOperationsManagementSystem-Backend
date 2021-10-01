package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customExceptionHandler.CustomExceptionHandler;
import com.app.dao.IUserRepository;
import com.app.dto.LoginResponse;
import com.app.dto.RegisterRequest;
import com.app.pojos.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public LoginResponse authenticateUser(String email, String pass) {
		
		User user = userRepo.findByEmailAndPassword(email, pass)
				.orElseThrow(() -> new CustomExceptionHandler("Authentication failed..."));
		
		return new LoginResponse(user.getEmail());
	}

	@Override
	public void signup(RegisterRequest registerRequest) {
		User user = new User(); //Transient
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		user.setDob(registerRequest.getDob());
		user.setGender(registerRequest.getGender());
		user.setName(registerRequest.getName());
		user.setPhone(registerRequest.getPhone());
		user.setAddress(registerRequest.getAddress());
		
		userRepo.save(user);//Persist
	}

}
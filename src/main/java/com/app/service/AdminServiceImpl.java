package com.app.service;

import javax.transaction.Transactional;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customExceptionHandler.CustomExceptionHandler;
import com.app.dao.IAdminRepository;
import com.app.dto.LoginResponse;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private IAdminRepository adminRepo;

	@Override
	public LoginResponse adminLogIn(String email, String pass) {
		// TODO Auto-generated method stub
		 adminRepo.findByEmailAndPassword(email,pass).orElseThrow(() -> new CustomExceptionHandler("Authentication failed..."));
		 return new LoginResponse(email);
	}

}

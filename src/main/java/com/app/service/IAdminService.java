package com.app.service;

import org.springframework.stereotype.Service;

import com.app.dto.LoginResponse;

@Service
public interface IAdminService {

	public LoginResponse adminLogIn(String email, String pass);
}

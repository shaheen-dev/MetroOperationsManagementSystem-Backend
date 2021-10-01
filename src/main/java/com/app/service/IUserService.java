package com.app.service;

import javax.servlet.http.HttpSession;

import com.app.dto.LoginResponse;
import com.app.dto.RegisterRequest;

public interface IUserService {

	public LoginResponse authenticateUser(String email, String pass);

	public void signup(RegisterRequest registerRequest); 

}

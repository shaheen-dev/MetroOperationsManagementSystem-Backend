package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequest;
import com.app.dto.RegisterRequest;
import com.app.service.IUserService;
import com.app.service.SendMail;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
    private SendMail mail;

	//User sign in method
	@PostMapping("/sign_in")
	public ResponseEntity<?> signIn(@RequestBody @Valid LoginRequest request, HttpSession session) {
		
		return ResponseEntity.ok(userService.authenticateUser(request.getEmail(), request.getPassword()));
	}
	
	
	//User sign up method
	@PostMapping("/sign_up")
	public ResponseEntity<?> signUp(@RequestBody RegisterRequest registerRequest) {
		
			userService.signup(registerRequest);
			//mail.sendMail(new NotificationEmail("Sign Up",registerRequest.getEmail(),"You have successfully created account with us!!!\n"+"Click here to login with your account- \n"+"https://localhost:8080/sign_in"));

			return new ResponseEntity<>("User Registered Successfully!!!", HttpStatus.OK);
		}
	
}

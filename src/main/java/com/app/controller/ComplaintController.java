package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserEmailRequest;
import com.app.dto.RegisterComplaint;
import com.app.service.IComplaintService;
import com.app.service.SendMail;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/user/complaints")
public class ComplaintController {

	@Autowired
	private IComplaintService complaintService;
	
	@Autowired
    private SendMail mail;
	
	@PostMapping("/")
	public ResponseEntity<?> displayAllComplaintsByEmail(@RequestBody UserEmailRequest request)
	{
		return new ResponseEntity<>(complaintService.displayAllComplaintsByEmail(request),HttpStatus.OK);
	}
	
	@PostMapping("/register_complaint")
	public ResponseEntity<?> registerComplaint(@RequestBody RegisterComplaint complaint)
	{
		
		if(complaintService.registerComplaint(complaint)==null)
			return new ResponseEntity<>("Complaint Registration failed!!!",HttpStatus.INTERNAL_SERVER_ERROR);
		
		//mail.sendMail(new NotificationEmail("Complaint Registered",complaint.getEmail(),"Your complaint has been registered successfully!!!"));
			
		return new ResponseEntity<>("Complaint Register Successfully",HttpStatus.OK);
		
	}
	
}

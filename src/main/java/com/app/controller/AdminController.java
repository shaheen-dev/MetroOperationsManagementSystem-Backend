package com.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.AdminDataResponse;
import com.app.dto.LoginRequest;
import com.app.dto.ReplyToComplaint;
import com.app.pojos.Complaints;
import com.app.pojos.MetroCard;
import com.app.service.IAdminService;
import com.app.service.IComplaintService;
import com.app.service.IMetroCardService;
import com.app.service.IPaymentService;

//---------------------------- Admin user Controller-----------------------------*/

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000/") 			//<== Allow third party sites to access this API
public class AdminController {
	
	@Autowired 
	private IMetroCardService service;
	
	@Autowired
	private IComplaintService complaintService;
	
	@Autowired
	private IPaymentService paymentService;
	
	@Autowired
	private IAdminService adminService;
	
	
	
//-------------- Admin Sign in---------------*/
	@PostMapping("/sign_in")
	public ResponseEntity<?> signIn(@RequestBody @Valid LoginRequest request) {
		
		return ResponseEntity.ok(adminService.adminLogIn(request.getEmail(), request.getPassword()));
	}
	
	
	
//-------------- Method to access Admin Dashboard Data---------------*/
	@GetMapping("/")
	public ResponseEntity<?> fetchAllData()
	{
		AdminDataResponse  data= new AdminDataResponse();
		
		data.setPendingComplaints(complaintService.getAllPendingComplaints());
		data.setTotalCards(service.getAllAppovedCards());
		data.setTotalComplaints(complaintService.getAllComplaints());
		data.setTotalPendingCards(service.getAllPendingCardRequest());
		data.setTotalRecharge(paymentService.getAllCardRecharge());
		data.setTotalTickets(paymentService.getAllTickets());
		
		return new ResponseEntity<AdminDataResponse>(data,HttpStatus.OK);
	}
	
	
	
//-------------- Method to access approval pending cards data ---------------*/
	@GetMapping("/issueCards")
	public ResponseEntity<?> issueCard(){
		
		return new ResponseEntity<List<MetroCard>>(service.fetchCards(), HttpStatus.OK ); 
	}

	
	
//-------------- Method to approve cards  ---------------*/
	@PutMapping("/issueCard/{id}")
	public ResponseEntity<?> issueCard(@PathVariable int id){
		
		return new ResponseEntity<String>(service.issueCard(id), HttpStatus.OK ); 
	}
	
	
	
//-------------- Method to access all complaints including pending ---------------*/	
	@GetMapping("/complaints")
	public ResponseEntity<?> displayComplaints(){
		
		return new ResponseEntity<List<Complaints>>(complaintService.displayAllComplaints(), HttpStatus.OK ); 
	}
	
	
	
//-------------- Method to reply complaints ---------------*/
	@PutMapping("/replyToComplaint/{id}")
	public ResponseEntity<?> displayComplaints(@PathVariable int id, @RequestBody ReplyToComplaint msgString){
		
		return new ResponseEntity<String>(complaintService.replyToComplaints(id, msgString), HttpStatus.OK ); 
	}
	
}

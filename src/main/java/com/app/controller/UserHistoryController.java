package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TransactionRequest;
import com.app.dto.UserEmailRequest;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/user/history")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserHistoryController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/save")
	public ResponseEntity<?> transactionHistory(@RequestBody TransactionRequest request)
	{
		return ResponseEntity.ok(paymentService.bookingHistory(request));
	}
	
	@PostMapping("/display")
	public ResponseEntity<?> displayTransactionHistory(@RequestBody UserEmailRequest request)
	{
		return ResponseEntity.ok(paymentService.displayHistory(request));
	}
}

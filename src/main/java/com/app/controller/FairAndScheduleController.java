package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IBookingService;
import com.app.service.ITripDetailsService;

@RestController
@RequestMapping("/user/fair_and_Schedule")
@CrossOrigin(origins = "http://localhost:3000/")
public class FairAndScheduleController {

	@Autowired
	private ITripDetailsService tripDetailsService;
	
	@Autowired
	private IBookingService bookService;
	
	@GetMapping("/fair/{id}")
	public ResponseEntity<?> getFairFromStation(@PathVariable int id) {
		return ResponseEntity.ok(bookService.getFairFromStation(id));
	}
	
	  
	@GetMapping("/schedule/{id}")
	public ResponseEntity<?> getSchedule(@PathVariable int id)
	  { 
		  return ResponseEntity.ok(tripDetailsService.getSchedule(id));
	  }
	
}

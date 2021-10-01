package com.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserEmailRequest;
import com.app.dto.MetroCardRequest;
import com.app.dto.RechargeRequest;
import com.app.dto.ResponseMessage;
import com.app.pojos.MetroCard;
import com.app.service.IMetroCardService;
import com.app.service.SendMail;

@RestController
@RequestMapping("/user/metro_card")
@CrossOrigin(origins = "http://localhost:3000/")
public class MetroCardController {

	@Autowired
	private IMetroCardService metroService;
	
	@Autowired
    private SendMail mail;
	
	@PostMapping("/request_card")
	public ResponseEntity<ResponseMessage> requestForMetroCard(@RequestBody MetroCardRequest request)
	{
		
		MetroCard card = new MetroCard();
		try {
			card = 	metroService.requestMetroCard(request);
			
			if(card!=null)
			{
				//mail.sendMail(new NotificationEmail("Metro Card request",card.getUser().getEmail(),"Your MetroCard request has been received successfully !!!")); 
				return ResponseEntity.ok(new ResponseMessage("Your MetroCard request has been received successfully !!!"));
			}
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("User already having MetroCard"));
						
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Could not proceed your request! Please try again!!!"));
		}
		
	}
	
	@PostMapping("/card_authenticate")
	public ResponseEntity<?> cardAuthenticate(@RequestBody RechargeRequest request)
	{
	
		return ResponseEntity.ok(metroService.cardAuthenticate(request));
		
	}
	
	
	@PutMapping("/card_recharge")
	public ResponseEntity<?> cardRecharge(@RequestBody RechargeRequest request)
	{
		return ResponseEntity.ok(metroService.rechargeCard(request));
		
	}
	@PostMapping("/card")
	public ResponseEntity<?> checkBalance(@RequestBody UserEmailRequest request)
	{
		
		return ResponseEntity.ok(metroService.fetchCardDetails(request));
		
	}

	
}

package com.app.service;

import java.io.IOException;
import java.util.List;

import com.app.dto.UserEmailRequest;
import com.app.dto.MetroCardRequest;
import com.app.dto.RechargeRequest;
import com.app.pojos.MetroCard;

public interface IMetroCardService {

	public MetroCard requestMetroCard(MetroCardRequest request) throws IOException;
	//public double checkBalance(UserEmailRequest request);
	public String rechargeCard(RechargeRequest request);
	public MetroCard fetchCardDetails(UserEmailRequest request);
	public List<MetroCard> fetchCards();
	public String issueCard(int id);
	public int getAllAppovedCards();
	public int getAllPendingCardRequest();
	public MetroCard cardAuthenticate(RechargeRequest request);
	
}

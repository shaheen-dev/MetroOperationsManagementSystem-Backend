package com.app.service;

import java.util.List;

import com.app.dto.FairResponse;
import com.app.dto.TicketRequest;
import com.app.dto.TicketResponse;

public interface IBookingService {

	public TicketResponse bookTicket(TicketRequest trequest);
	public List<FairResponse> getFairFromStation(int id);
}

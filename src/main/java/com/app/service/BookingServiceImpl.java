package com.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFairRepository;
import com.app.dao.IStationRepository;
import com.app.dto.FairRequest;
import com.app.dto.FairResponse;
import com.app.dto.TicketRequest;
import com.app.dto.TicketResponse;
import com.app.pojos.Fair;
import com.app.pojos.Station;


@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IFairRepository fairRepo;
	
	@Autowired
	private IStationRepository stationRepo;
	
	@Autowired
	private PaymentService payService;
	
	@Override
	public TicketResponse bookTicket(TicketRequest trequest) {
		String journey="";
		int amount=0;
		
		
		int fair =fairRepo.getFairAmount(trequest.getSourceId(),trequest.getDestinationId());
		
		if(trequest.isJourneyType())
		{
			journey="RETURN";
			amount=fair*trequest.getQuantity()*2;
		}
		else {
		journey="ONE-WAY";
		amount=fair*trequest.getQuantity();
		}
		
		return new TicketResponse(trequest.getSourceId(),trequest.getDestinationId(),trequest.getQuantity(),journey,amount,LocalDateTime.now());
		
		
		
	}
	
	@Override
	public List<FairResponse> getFairFromStation(int id) {
		
		ArrayList<FairResponse> resp = new ArrayList<FairResponse>();
		
		ArrayList<Fair> flist = new ArrayList<Fair>();
		flist = (ArrayList<Fair>) fairRepo.getFairFromStation(id);
		for (Fair fair2 : flist) {		
			resp.add(new FairResponse(stationRepo.getStationById(fair2.getDestination()).getName(),fair2.getAmount()));
		}
		return resp;
	}

	
}

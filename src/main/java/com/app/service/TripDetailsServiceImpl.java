package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ITripDetailsRepository;
import com.app.dao.ITripRepository;
import com.app.dto.ScheduleRequest;
import com.app.dto.ScheduleResponse;
import com.app.pojos.Trip;
import com.app.pojos.TripDetails;

@Service
public class TripDetailsServiceImpl implements ITripDetailsService{

	@Autowired
	private ITripDetailsRepository tripDetailRepo;
	
	@Autowired
	private ITripRepository tripRepo;
	
	@Override
	public List<ScheduleResponse> getSchedule(int id) {
		
		List<ScheduleResponse> resp = new ArrayList<>();
		
		List<TripDetails> tripDetails =tripDetailRepo.getScheduleById(id);
		
		for (TripDetails t : tripDetails) {
			
			Trip trip= tripRepo.getTrainNoByTripId(t.getTripNo());
			
			String towards=tripRepo.getTowardsStationName(t.getTripNo());
			
			resp.add(new ScheduleResponse(trip.getTrain().getId(),t.getTripNo(),towards,t.getArrivalTime().getHour()+":"+t.getArrivalTime().getMinute(),t.getDepartureTime().getHour()+":"+t.getDepartureTime().getMinute()));
		}
			System.out.println(resp.toString());
			
		return resp;
	}
}

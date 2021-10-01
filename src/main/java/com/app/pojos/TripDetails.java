package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trip_details")
public class TripDetails extends BaseEntity {

	@Column(nullable = false, name = "route_id")
	private int routeId;
	
	@Column(nullable = false, name = "trip_id")
	private int tripNo;
	
	@Column(nullable = false,name="station_id")
	private int sId;
	

	@Column(nullable = false,name = "arrival_time")
	private LocalDateTime arrivalTime;
	
	
	@Column(nullable = false,name = "departure_time")
	private LocalDateTime departureTime;
	
}

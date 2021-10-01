package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TicketRequest {

	private int sourceId;
	private int destinationId;
	private int quantity;
	private boolean journeyType;  // 0- one way; 1- return journey
	//private Map order;
	
}

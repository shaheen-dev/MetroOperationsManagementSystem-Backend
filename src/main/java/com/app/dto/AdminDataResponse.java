package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDataResponse {

	
	
	private int totalTickets ;
	private int totalRecharge ;
	private int totalCards;
	private int totalPendingCards;
	private long totalComplaints;
	private int pendingComplaints;
}

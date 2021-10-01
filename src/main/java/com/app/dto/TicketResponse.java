package com.app.dto;

import java.time.LocalDateTime;

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
public class TicketResponse {

	private int sourceId;
	private int destinationId;
	private int quantity;
	private String journeyType;  // 0- one way; 1- return journey
	private int fair;
	private LocalDateTime timeStamp;
}

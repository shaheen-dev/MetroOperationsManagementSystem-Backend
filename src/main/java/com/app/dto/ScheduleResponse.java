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
public class ScheduleResponse {

	private int trainNo;
	private int tripNo;
	private String towards;
	private String arrivalTime;
	private String departureTime;
	
}

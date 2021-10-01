package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_history")
public class BookingHistory extends BaseEntity {

	@Column(nullable = false)
	private long bookingId;
	
	@Column(length=50, nullable = false)
	private String source;
	
	@Column(length=50,nullable = false)
	private String destination;
	
	@Column(nullable = false)
	private int fair;
	
	@CreationTimestamp
	private LocalDateTime timeStamp;
	
	@Column(length=50,nullable = false)
	private String status;
	
	
	
	
}

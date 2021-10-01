package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class History  extends BaseEntity{

	
	 private String transactionType;
	 private String payment_id;
	 private String source;
	 private String destination;
	 private String amount;
	 private String status;
	 private String email;
	 private LocalDateTime timeStamp;
}

package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionRequest {

	 private String transactionType;
	 private String payment_id;
	 private int source;
	 private int destination;
	 private String amt;
	 private String status;
	 private String email;
}

package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.dto.TransactionRequest;
import com.app.dto.UserEmailRequest;
import com.app.pojos.History;
import com.razorpay.Order;

public interface IPaymentService {

	public Order payment( Map<String, Object> data);
	public String bookingHistory(TransactionRequest obj);
	List<History> displayHistory(UserEmailRequest req);
	public int getAllTickets();
	public int getAllCardRecharge();
}

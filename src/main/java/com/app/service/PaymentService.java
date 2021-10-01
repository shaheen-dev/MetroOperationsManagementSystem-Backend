package com.app.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IHistoryRepository;
import com.app.dao.IStationRepository;
import com.app.dto.NotificationEmail;
import com.app.dto.TransactionRequest;
import com.app.dto.UserEmailRequest;
import com.app.pojos.History;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class PaymentService implements IPaymentService {

@Autowired
IHistoryRepository historyRepo;

@Autowired
IStationRepository stationRepo;

@Autowired
private SendMail mail;


	@Override
	public Order payment( Map<String, Object> data)
	{
		 try {
				RazorpayClient razorpay = new RazorpayClient("rzp_test_zhjmZId0SjXCfp", "hrEwmRtfS08mIuJ5W8sV6BtE");
				Map<String, String> headers = new HashMap<String, String>();
				headers.put("Content-Type","application/json");
				razorpay.addHeaders(headers);
				
				  JSONObject orderRequest = new JSONObject();

				  orderRequest.put("amount", Integer.parseInt(data.get("amount").toString())*100); 

				  orderRequest.put("currency", "INR");

				  orderRequest.put("receipt", data.get("receipt"));

				  Order order = razorpay.Orders.create(orderRequest);
				  
				  System.out.println(order.toString());
				
				  
				  return order;
				  
				} catch (RazorpayException e) {

				  System.out.println(e.getMessage());

				}
		return null;
		  
		  
	}
	@Override
	public String bookingHistory(TransactionRequest obj)
	{
		History tran = new History();
		
		if(obj.getTransactionType().equals("Ticket Booking"))
		{
		
		tran.setAmount(obj.getAmt());
		tran.setDestination(stationRepo.getStationById(obj.getDestination()).getName());
		tran.setPayment_id(obj.getPayment_id());
		tran.setSource(stationRepo.getStationById(obj.getSource()).getName());
		tran.setStatus(obj.getStatus());
		tran.setEmail(obj.getEmail());
		tran.setTransactionType(obj.getTransactionType());
		tran.setTimeStamp(LocalDateTime.now());
		historyRepo.save(tran);
		mail.sendMail(new NotificationEmail("Pune Metro Ticket",obj.getEmail(),"Hi,\nYour Ticket has been booked successfully!"+"\nTransaction ID: "+obj.getPayment_id()+"\nSource Station: "+tran.getSource()+"\nDestination Station: "+tran.getDestination()+"\nAmount:"+obj.getAmt()));
		}
		else {
			tran.setAmount(obj.getAmt());
			tran.setDestination("");
			tran.setPayment_id(obj.getPayment_id());
			tran.setSource("");
			tran.setStatus(obj.getStatus());
			tran.setEmail(obj.getEmail());
			tran.setTransactionType(obj.getTransactionType());
			tran.setTimeStamp(LocalDateTime.now());
			historyRepo.save(tran);
			mail.sendMail(new NotificationEmail("Metro Card recharge!!",obj.getEmail(),"Hi,\nYour Metro Card recharge successfully done!"+"\nTransaction ID: "+obj.getPayment_id()+"\nAmount:"+obj.getAmt()));
			}
		
		return "Transaction Saved!";
	}
	
	
	
	@Override
	public List<History> displayHistory(UserEmailRequest req){
	
		
		return historyRepo.findByEmail(req.getEmail());
		
	}
	@Override
	public int getAllTickets() {
		
		return historyRepo.getCountOfTickets();
	}
	@Override
	public int getAllCardRecharge() {
		// TODO Auto-generated method stub
		return historyRepo.getCountOfRecharge();
	}
}

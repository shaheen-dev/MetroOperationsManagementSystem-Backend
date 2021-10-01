package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customExceptionHandler.CustomExceptionHandler;
import com.app.dao.IMetroCardRepository;
import com.app.dao.IUserRepository;
import com.app.dto.UserEmailRequest;
import com.app.dto.MetroCardRequest;
import com.app.dto.NotificationEmail;
import com.app.dto.RechargeRequest;
import com.app.pojos.MetroCard;
import com.app.pojos.User;

@Service
@Transactional
public class MetroCardServiceImpl implements IMetroCardService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IMetroCardRepository metroRepo;

	@Autowired
    private SendMail mail;
	
	
	@Override
	public MetroCard requestMetroCard(MetroCardRequest request) throws IOException {
		
		
		User user = userRepo.findByEmail(request.getUser());
	System.out.println(user.getCard());
		if(user.getCard()!=null)
			return null;
		else
		{
		MetroCard card = new MetroCard();
		//byte[] iCard = request.getICard().getBytes();
		card.setICard(null);//Identity card image
		card.setBalance(0);
		card.setCardNo("");
		card.setICardNo(request.getiCardNo());
		card.setPin(request.getPin());
		card.setUser(user);
		
		metroRepo.save(card);
		user.setCard(card);
		userRepo.save(user);
	
		return card;
		}
		
	}



	@Override
	public String rechargeCard(RechargeRequest request) {
		
		MetroCard card = cardAuthenticate(request); 
		  card.setBalance(card.getBalance()+request.getAmount());
		  metroRepo.save(card);
		  //mail.sendMail(new NotificationEmail("Metro Card Recharge",card.getUser().getEmail(),"Hi,"+card.getUser().getName()+"\nYour MetroCard recharged successfully with amount "+request.getAmount()+ " !!!\n"+"Your updated balance is "+card.getBalance()));
		 return "Card recharge successfully!!!";
	}

	@Override
	public MetroCard fetchCardDetails(UserEmailRequest request) {
		System.out.println(request.getEmail());
		User user = userRepo.findByEmail(request.getEmail());
		int id = user.getId();
		System.out.println(id);
		return metroRepo.getByUserId(id);
	}
	
	@Override
	public MetroCard cardAuthenticate(RechargeRequest request) {
		
		return  metroRepo.findByCardNoAndPin(request.getCardNo(),request.getPin()).orElseThrow(() -> new CustomExceptionHandler("Invalid card details or password..."));
	}

	// ------------------Admin Module---------------
	
	@Override
	public String issueCard(int id) {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		var card = metroRepo.getById(id);
		card.setCardStatus(true);
		card.setCardNo(String.valueOf(number));
		return "Card Issued Successfully!!!";
	}

	@Override
	public List<MetroCard> fetchCards() {
		
		return metroRepo.allPendingCards();
	}

	@Override
	public int getAllAppovedCards() {
		
		return metroRepo.getCountOfApprovedCards();
	}

	@Override
	public int getAllPendingCardRequest() {
		
		return metroRepo.getAllPendingCardRequest();
	}

	


}

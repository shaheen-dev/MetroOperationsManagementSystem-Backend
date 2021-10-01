package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.History;

public interface IHistoryRepository extends JpaRepository<History, Integer> {

	List<History> findByEmail(String email);

	@Query("select count(t) from History t where t.transactionType='Ticket Booking'")
	int getCountOfTickets();

	@Query("select count(t) from History t where t.transactionType='Card Recharge'")
	int getCountOfRecharge();

}

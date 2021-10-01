package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.MetroCard;

@Repository
public interface IMetroCardRepository extends JpaRepository<MetroCard, Integer> {

	public Optional<MetroCard> findByCardNoAndPin(String cardNo, int pin);
	public byte[] getICardById(int id);
	
	@Query("select c from MetroCard c join fetch c.user u where u.id=:id")
	public MetroCard getByUserId(@Param("id") int id);

	@Query("select c from MetroCard c where c.cardStatus = false")
	public List<MetroCard> allPendingCards();
	
	@Query("select count(t) from MetroCard t where t.cardStatus=true")
	public int getCountOfApprovedCards();
	
	@Query("select count(t) from MetroCard t where t.cardStatus=false")
	public int getAllPendingCardRequest();

}

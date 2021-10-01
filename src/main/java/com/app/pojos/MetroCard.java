package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "metro_card")
public class MetroCard extends BaseEntity {

	@Column(length = 30,name = "card_no",nullable = true)
	private String cardNo;
	
	@Column(length = 20,nullable = false)
	private String iCardNo;
	
	@Column
	private int pin;
	
	@Column(nullable = true)
	private boolean cardStatus;
	
	@Column(nullable = true)
	private double balance;
	
	@Lob
	@Column(name="i_card")
	private byte[] iCard;
	
	@OneToOne//(mappedBy = "card")
	@JsonIgnoreProperties("card")
	private User user;
	
}

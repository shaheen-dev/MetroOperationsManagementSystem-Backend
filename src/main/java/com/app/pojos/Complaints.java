package com.app.pojos;

import java.time.LocalDate;

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
@Table(name = "complaints")
public class Complaints extends BaseEntity {

	@Column(length = 20,name="u_name",nullable = false)
	private String name;
	
	@Column(length = 50,name="u_address",nullable = false)
	private String address;

	@Column(length = 20,name="phone_num",nullable = false)
	private String phone;
	
	@Column(length = 200,nullable = false)
	private String msg;
	
	@Column(length = 30,nullable = false)
	private String email;
	
	@Column
	private boolean status;

	@CreationTimestamp
	@Column(name="date_time")
	private LocalDate dateTime;
	
	@Column(length = 200)
	private String response;
	
}

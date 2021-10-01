package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "user")
public class User extends BaseEntity{

	@NotBlank(message = "email is required!")
	@Column(length = 50,unique = true,nullable = false)
	private String email;
	
	@NotBlank(message = "password is required!")
	@Column(length = 20,nullable = false)
	private String password;
	@Column(length = 30,name = "u_name",nullable = false)
	private String name;
	@Column(length = 30,name = "phone_num",nullable = false)
	private String phone;
	
	@Column(length = 50,name = "u_address",nullable = false) 
	private String address;
	
	@Column(nullable = false) 
	private LocalDate dob;
	@Column(nullable = false)
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private MetroCard card;
	
	
	
}

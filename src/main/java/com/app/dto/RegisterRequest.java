package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	private String email;
	private String password;
	private String name;
	private String address;
	private String phone;
	private LocalDate dob;
	private String gender;
}

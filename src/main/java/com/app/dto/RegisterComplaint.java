package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterComplaint {

	private String name;
	private String email;
	private String address;
	private String phone;
	private String  msg;
}

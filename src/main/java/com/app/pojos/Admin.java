package com.app.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin extends BaseEntity {

	@NotBlank(message = "email is required!")
	@Column(length = 30, unique = true, nullable = false)
	private String email;

	@NotBlank(message = "password is required!")
	@Column(length = 20, nullable = false)
	private String password;
	
	@Column(length = 30, name = "a_name", nullable = false)
	private String name;
	
	@Column(length = 30, name = "phone_num", nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(length = 30, name = "a_address", nullable = false)
	private String address;
	
	@Column(nullable = false)
	private int permission;
	
	@Column(length = 20, nullable = false)
	private String designation;
}

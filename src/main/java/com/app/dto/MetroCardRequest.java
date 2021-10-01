package com.app.dto;

public class MetroCardRequest {
	/*
	 * private String name; private String address; private LocalDate dob; private
	 * String gender; private String phone; private String email;
	 */
	private String user;
	private String iCardNo;
	//sprivate MultipartFile iCard;
	private int pin;
	
	public MetroCardRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getiCardNo() {
		return iCardNo;
	}

	public void setiCardNo(String iCardNo) {
		this.iCardNo = iCardNo;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "MetroCardRequest [user=" + user + ", iCardNo=" + iCardNo + ", pin=" + pin + "]";
	}
	
	

	
	
}

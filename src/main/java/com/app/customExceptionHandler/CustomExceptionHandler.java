package com.app.customExceptionHandler;


/*----------------------------Custom Exception Handling-----------------------------*/

@SuppressWarnings("serial")
public class CustomExceptionHandler extends RuntimeException {

	public CustomExceptionHandler(String mesg) {
		super(mesg);
	}
}

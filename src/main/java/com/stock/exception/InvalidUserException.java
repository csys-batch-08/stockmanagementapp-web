package com.stock.exception;

public class InvalidUserException extends Exception {

	@Override
	public String getMessage() {
		
		return "Invalid Email or Password";
	}
	
	
	
	

}

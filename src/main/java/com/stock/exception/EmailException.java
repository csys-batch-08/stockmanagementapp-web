package com.stock.exception;

public class EmailException extends Exception{

	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "This Email Already Used  ";
	}

	
	
}

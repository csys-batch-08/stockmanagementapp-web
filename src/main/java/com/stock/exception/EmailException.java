package com.stock.exception;

public class EmailException extends Exception{

	
	@Override
	public String getMessage() {

		return "This Email Already Used  ";
	}

	
	
}

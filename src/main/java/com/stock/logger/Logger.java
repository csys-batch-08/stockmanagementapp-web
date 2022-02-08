package com.stock.logger;

public class Logger {

	private Logger() {

	}

	public static void printStackTrace(Exception e) {
		e.getMessage();
	}

	public static void runTimeException(String message) {
		throw new RuntimeException(message);
	}

}

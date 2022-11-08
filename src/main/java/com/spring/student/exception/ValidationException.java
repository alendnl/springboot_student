package com.spring.student.exception;

@SuppressWarnings("serial")
public class ValidationException extends Exception {
	
	public ValidationException() {
		super();
	}

	public ValidationException(String message) {
		super(message);
	}

}

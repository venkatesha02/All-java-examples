package com.tyss.springbootproduct.exception;

@SuppressWarnings("serial")
public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String msg) {
		super(msg);
	}
}

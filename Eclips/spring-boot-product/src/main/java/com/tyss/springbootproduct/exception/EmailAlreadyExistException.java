package com.tyss.springbootproduct.exception;

public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String msg) {
		super(msg);
	}
}

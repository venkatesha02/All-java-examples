package com.tyss.springboot.exception;

@SuppressWarnings("serial")
public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String msg) {
		super(msg);
	}
}

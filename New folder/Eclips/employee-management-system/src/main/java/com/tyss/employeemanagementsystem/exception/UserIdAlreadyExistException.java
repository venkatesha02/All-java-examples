package com.tyss.employeemanagementsystem.exception;


@SuppressWarnings("serial")
public class UserIdAlreadyExistException extends RuntimeException {

	public UserIdAlreadyExistException(String str) {
		super(str);
	}
}

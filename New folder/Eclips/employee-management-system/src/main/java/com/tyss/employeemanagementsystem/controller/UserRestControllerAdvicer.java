package com.tyss.employeemanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.employeemanagementsystem.dto.UserResponse;
import com.tyss.employeemanagementsystem.exception.UserIdAlreadyExistException;

@RestControllerAdvice
public class UserRestControllerAdvicer {

	@ExceptionHandler(UserIdAlreadyExistException.class)
	public UserResponse emailAlreadyExist(UserIdAlreadyExistException e) {
		
		UserResponse response = new UserResponse();
		response.setMessage("Exception");
		response.setStatusCode(501);
		response.setDescription(e.getMessage());
		return response;
		
	}
}

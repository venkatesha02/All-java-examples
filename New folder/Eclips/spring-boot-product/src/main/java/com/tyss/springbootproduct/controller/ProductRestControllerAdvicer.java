package com.tyss.springbootproduct.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.springbootproduct.dto.ProductResponse;
import com.tyss.springbootproduct.exception.EmailAlreadyExistException;

@RestControllerAdvice
public class ProductRestControllerAdvicer {

	@ExceptionHandler(EmailAlreadyExistException.class)
	public ProductResponse emailAlreadyExist(EmailAlreadyExistException e) {
			
		ProductResponse response = new ProductResponse();
		response.setMessage("Exception");
		response.setStatusCode(501);
		response.setDescription(e.getMessage());
		return response;
	}
}

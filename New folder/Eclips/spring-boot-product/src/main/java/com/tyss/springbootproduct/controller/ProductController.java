package com.tyss.springbootproduct.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springbootproduct.dto.ProductInfo;
import com.tyss.springbootproduct.dto.ProductResponse;
import com.tyss.springbootproduct.service.ProductService;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = "*")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(path="/add", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductInfo info) {
	
		ProductResponse response = new ProductResponse();
		if(service.addProduct(info)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data inserte in to db");
			
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Data not inserte in to db");
		}
		return response;		
	}
	
	
	
}

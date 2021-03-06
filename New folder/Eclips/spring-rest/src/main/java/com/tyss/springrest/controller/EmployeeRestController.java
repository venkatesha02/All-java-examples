package com.tyss.springrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springrest.dto.EmployeeInfoBean;
import com.tyss.springrest.dto.EmployeeResponse;
import com.tyss.springrest.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	public EmployeeService service;
	
	@GetMapping(path="/search", 
			produces=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody  : its specifies there is no any jsp code for view. this methos itself that body.
	public EmployeeResponse search(@RequestParam("name")String name) {
		List<EmployeeInfoBean> bean = service.search(name);
		EmployeeResponse response = new EmployeeResponse();
		if(bean!=null && !bean.isEmpty()) {
			
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data found in DB for the Requested Name");
			response.setBeans(bean);
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not found in DB for the Requested Name");
			
		}
		return response;
		
	}
	
	@PostMapping(path="/register", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse register(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if(service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Inserted in DB");
			
		}else {
			
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not inserted in DB ");
			
		}
		return response;
		
	}
	
	@PostMapping(path="/auth", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse auth(@RequestBody EmployeeInfoBean bean) {
		
		EmployeeResponse response = new EmployeeResponse();
		EmployeeInfoBean infoBean = service.auth(bean.getEmail(), bean.getPassword());
		
		if( infoBean!= null) {
			
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Authenticated in DB");
			response.setBeans(Arrays.asList(bean));// it will create the array and send 
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not Authenticated in DB ");
			
		}
		return response;
	}
	
	@PostMapping(path = "/change-password", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse changePassword(@RequestBody EmployeeInfoBean bean) {
		
		EmployeeResponse response = new EmployeeResponse();
		
		if(service.changePassword(bean.getId(), bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Updated in DB");
			response.setBeans(Arrays.asList(bean));
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Updated in DB");
		}
		return response;
		
	}
	
	@DeleteMapping(path = "/delete/{id}", // path variavbles same name you have to give
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@PathVariable("id")int id) {
		EmployeeResponse response = new EmployeeResponse();
		
		if(service.delete(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Deleted in DB");
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Deleted in DB");
		}
		return response ;
	}
}// end of class

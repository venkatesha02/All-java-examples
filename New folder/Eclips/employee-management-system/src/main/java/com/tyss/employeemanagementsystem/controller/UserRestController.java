package com.tyss.employeemanagementsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.employeemanagementsystem.dto.UserInfoBean;
import com.tyss.employeemanagementsystem.dto.OtherInfoBean;
import com.tyss.employeemanagementsystem.dto.UserResponse;
import com.tyss.employeemanagementsystem.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class UserRestController {

	Logger log = LogManager.getLogger();

	@Autowired
	private UserService service;

	@PostMapping(path = "/add-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addUser(@RequestBody UserInfoBean bean) {
		UserResponse response = new UserResponse();
		if (service.addUser(bean)) {

			//log.info("hiii");
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Inserted in DB");
			response.setStatus(true);

		} else {

			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not inserted in DB ");
			response.setStatus(false);

		}
		return response;

	}// end of addUser

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public UserResponse authenticate(@RequestBody UserInfoBean info) {

		UserResponse response = new UserResponse();
		UserInfoBean bean = service.auth(info.getEmail(), info.getPassword());
		if(bean!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Authenticated");
			response.setStatus(true);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Invalid Credentials");
			response.setStatus(false);
		}
		return response;
	}//end of authenticate()

	@GetMapping(path="/employee-list",produces=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllEmp() {

		List<UserInfoBean> bean = service.getAllEmp();
		UserResponse response = new UserResponse();
		if(bean!=null && !bean.isEmpty()) {

			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data found in DB for the Requested Name");
			response.setStatus(true);
			response.setInfoBeans(bean);

		}else {

			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not found in DB for the Requested Name");
			response.setStatus(false);

		}
		return response;

	}// end of getAllEmp();

	@PostMapping(path = "/update", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@RequestBody UserInfoBean bean) {

		UserResponse response = new UserResponse();

		if(service.updateUser(bean)) {

			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Updated in DB");
			response.setStatus(true);
			response.setInfoBeans(Arrays.asList(bean));

		}else {

			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Updated in DB");
			response.setStatus(false);
		}
		return response;
	}// end of updateUser();
	
	
	@GetMapping(path = "/list", 
			produces = MediaType.APPLICATION_JSON_VALUE)
			
	public UserResponse find (@RequestParam ("userId") int id) {
		
		OtherInfoBean bean = service.find(id);
		UserResponse response = new UserResponse();
		
		if(bean!=null ) {
			
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data found in DB for the Requested Name");
			response.setStatus(true);
			response.setBans(Arrays.asList(bean));

		}else {

			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not found in DB for the Requested Name");
			response.setStatus(false);

		}
		return response;

		
	}


}// end of class

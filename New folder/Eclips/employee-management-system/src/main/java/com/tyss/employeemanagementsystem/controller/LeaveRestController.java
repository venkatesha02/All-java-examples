package com.tyss.employeemanagementsystem.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.employeemanagementsystem.dto.LeaveResponse;
import com.tyss.employeemanagementsystem.dto.LeaveInfoBean;
import com.tyss.employeemanagementsystem.service.LeaveService;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "*")
public class LeaveRestController {

	Logger log = LogManager.getLogger();

	@Autowired
	private LeaveService service;

	@PostMapping(path = "/apply-leave", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LeaveResponse addLeave(@RequestBody LeaveInfoBean bean) {
		LeaveResponse response =  new LeaveResponse();
		if(service.applyLeave(bean)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User Leave Applyed.");
		}else {
			response.setStatusCode(500);
			response.setMessage("Failure");
			response.setDescription("Sorry!! Unable to Process User Request");
		}
		return response;
	}

}// end of class

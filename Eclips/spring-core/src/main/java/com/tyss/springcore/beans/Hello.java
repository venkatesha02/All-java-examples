package com.tyss.springcore.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;

import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log
public class Hello implements InitializingBean { // this implementation only for lifecycle
		
	private String message;
	private Map<Integer, String> map;
	private List<Integer> list;

	@PostConstruct
	public void init() {
		log.info("Init method");
	}
	
	@PreDestroy
	public void destroy(){
		log.info("destroy methods");
	}
	
	
	public Hello() {
		log.info("Hello Object created");
	}
	
	public Hello(String message) {

		log.info(message);
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("afterPropertiesSet method");
	}
	
}// end of class
package com.tyss.springcore.beans;

import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class Dog implements Animal{

	@Override
	public void makeSound() {
		log.info("Baaoooooow");
		
	}
	
}

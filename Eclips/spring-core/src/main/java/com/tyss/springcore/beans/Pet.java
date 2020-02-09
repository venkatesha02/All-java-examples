package com.tyss.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Pet {

	
	@Autowired
	//@Qualifier("dog")
	private Animal animal;
	private String name;
	
	public Pet() {}
	
	public Pet(String name, Animal animal) {
		super();
		this.name = name;
		this.animal = animal;
	}
		
}
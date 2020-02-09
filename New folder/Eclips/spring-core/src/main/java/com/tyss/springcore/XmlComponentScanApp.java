package com.tyss.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.beans.Animal;
import com.tyss.springcore.beans.Pet;

public class XmlComponentScanApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Animal animal = context.getBean(Animal.class);
		animal.makeSound();
		
		Pet pet = context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		
	}

}

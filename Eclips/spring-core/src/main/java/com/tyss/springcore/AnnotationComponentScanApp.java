package com.tyss.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.springcore.beans.Animal;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;
import com.tyss.springcoreconfig.SpringConfig;

public class AnnotationComponentScanApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Animal animal = context.getBean(Animal.class);
		animal.makeSound();
		
		Hello hello = context.getBean(Hello.class);
		System.out.println(hello.getMessage());
		
		Pet pet= context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
	}

}

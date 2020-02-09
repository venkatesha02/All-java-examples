package com.tyss.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.springcore.beans.Animal;
import com.tyss.springcore.beans.Dog;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;
import com.tyss.springcoreconfig.BeansConfig;

import lombok.extern.java.Log;

@Log
public class AnnotationConfigApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		
		Hello hello =context.getBean(Hello.class);
		log.info(hello.getMessage());
		
		Hello hello1 =context.getBean(Hello.class);
		log.info(Boolean.toString(hello==hello1));
		
		log.info("-----------------------");
		
		Animal animal = context.getBean(Animal.class);
		animal.makeSound();
		
		log.info("-----------------------");
		
		Pet pet= context.getBean(Pet.class);
		log.info(pet.getName());
		pet.getAnimal().makeSound();
		
		log.info("-----------------------");
		
		Dog dog = context.getBean(Dog.class);
		log.info(Boolean.toString(pet.getAnimal()==dog));
		context.close();
				
	}
}

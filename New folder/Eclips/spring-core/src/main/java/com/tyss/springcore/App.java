package com.tyss.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.beans.Animal;
import com.tyss.springcore.beans.Author;
import com.tyss.springcore.beans.Book;
import com.tyss.springcore.beans.Hello;
import com.tyss.springcore.beans.Pet;

import lombok.extern.java.Log;

@Log
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		
		  Hello hello1 = context.getBean(Hello.class); log.info(hello1.getMessage());
		  log.info(hello1.getMap().toString());// using map
		  log.info(hello1.getList().toString());// using list
		  
		  Hello hello2 = context.getBean(Hello.class); log.info(hello2.getMessage());
		  
		  //both the objects are pointing to same reference variable
		  log.info(Boolean.toString(hello1==hello2));
		  
		  log.info("-----------------------");
		  
		  Animal animal = context.getBean(Animal.class); animal.makeSound();
		  
		  log.info("-----------------------");
		  
		  Pet pet = context.getBean(Pet.class); log.info(pet.getName());
		  pet.getAnimal().makeSound();
		  
		 
		context.close();

	}
}

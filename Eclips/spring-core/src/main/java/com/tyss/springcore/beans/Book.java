package com.tyss.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Book {

	private String name="vinay testyantra";
	@Autowired
	private Author author;
	
	public Book() {
		System.out.println("constructor Exicuted");
	}

	public Book(String name, Author author) {
		super();
		this.name = name;
		this.author = author;
	}
	 
}

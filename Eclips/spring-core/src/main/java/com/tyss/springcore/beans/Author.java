package com.tyss.springcore.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Author {

	private String name = "vvnmbv";
	private String penName="jhskjdh";
	
	public Author() {
		System.out.println("Author constructor executed");
	}

	public Author(String name, String penName) {
		super();
		this.name = name;
		this.penName = penName;
		System.out.println("Parametarised constructor executed");
	}
	
}
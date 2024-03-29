package com.tyss.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyss.springcore.beans.Author;
import com.tyss.springcore.beans.Book;

import lombok.extern.java.Log;

@Log
public class XmlBookConfigApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("book.xml");
		
		Author author = context.getBean(Author.class);
		log.info(author.getName());
		log.info(author.getPenName());

		Book book = context.getBean(Book.class);
		log.info(book.getName());
		System.out.println(book.getAuthor().getName());

		context.close();

		
	}

}

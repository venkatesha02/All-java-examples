package com.tyss.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.springcore.beans.Author;
import com.tyss.springcore.beans.Book;
import com.tyss.springcoreconfig.BookConfig;

import lombok.extern.java.Log;

@Log
public class BookConfigApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
		
		Author author = context.getBean(Author.class);
		log.info(author.getName());
		log.info(author.getPenName());

		Book book = context.getBean(Book.class);
		log.info(book.getName());
		System.out.println(book.getAuthor().getName());

		context.close();
	}
}

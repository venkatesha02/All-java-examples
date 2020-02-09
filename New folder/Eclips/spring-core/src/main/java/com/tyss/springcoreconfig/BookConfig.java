package com.tyss.springcoreconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.tyss.springcore.beans.Author;
import com.tyss.springcore.beans.Book;

@Configuration
public class BookConfig {
		
	@Bean
	public Author getAuthor() {
		Author author = new Author("Vinay TestYantra","TestYantra Vinay");
		//author.setName("Vinay Testyantra");
		//author.setPenName("TestYantra Vinay");
		return author;
	}
	
	@Bean
	public Book getBook() {
		Book book = new Book("Test Yantra",getAuthor());
		//book.setName("TestYantra");
		//book.setAuthor(getAuthor());
		return book;
	}
	
	
}

package com.tyss.springcoreconfig;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.tyss.springcore.beans.BeanFactoryPostProcessorImpl;
import com.tyss.springcore.beans.BeanPostProcessorImpl;
import com.tyss.springcore.beans.Cat;
import com.tyss.springcore.beans.Hello;

@Configuration
public class BeansConfig {

	@Bean("hello")
	@Scope("prototype")
	public Hello getHello() {
		Hello hello = new Hello();
		hello.setMessage("I love Spring");
		return hello;
	}
	@Bean("beanFactoryPostProcessor")
	public BeanFactoryPostProcessor  getBeanFactoryPostProcessor() {
		return new BeanFactoryPostProcessorImpl();
	}
	
	@Bean("beanPostProcessor")
	public BeanPostProcessor getBeanPostProcessor() {
		return new BeanPostProcessorImpl();
	}
	
	/*
	 * @Bean public Dog getDog() { return new Dog(); }
	 */
	
	@Bean
	@Primary
	public Cat getCat() {
		return new Cat();
	}
	
//	@Bean
//	public Pet getPet() {
////		Pet pet = new Pet("Browni",pet.getAnimal());
//		Pet pet = new Pet();
//		pet.setName("Browni");
//		pet.setAnimal(getDog());
//		return pet;
//	}
}

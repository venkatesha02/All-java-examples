package com.tyss.springcore.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import lombok.extern.java.Log;

@Log
public class BeanPostProcessorImpl implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info(beanName+" Before init ");
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info(beanName+" After init ");
		return bean;
	
	}
}

package com.tyss.springcore.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import lombok.extern.java.Log;

@Log
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("postProcessBeanFactory method");
		
	}

}

package com.tyss.springcoreconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeansConfig.class)
@ComponentScan(basePackages = "com.tyss.springcore.beans")
public class SpringConfig {
	
	
}

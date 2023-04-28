package com.ssafy.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring12HelloBootApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Spring12HelloBootApplication.class, args);
		
		for(String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}

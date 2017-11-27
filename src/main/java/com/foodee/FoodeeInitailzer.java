package com.foodee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:foodee.properties")
public class FoodeeInitailzer {
	
	public static void main(String[] args) {
		SpringApplication.run(FoodeeInitailzer.class, args);
	}
}



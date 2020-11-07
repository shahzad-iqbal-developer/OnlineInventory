package com.inventory.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(OrderApplication.class);
		logger.info("Application Started");

		SpringApplication.run(OrderApplication.class, args);
	}

}

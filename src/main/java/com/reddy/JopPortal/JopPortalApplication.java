package com.reddy.JopPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.reddy.JopPortal.Service")
public class JopPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JopPortalApplication.class, args);
	}

}

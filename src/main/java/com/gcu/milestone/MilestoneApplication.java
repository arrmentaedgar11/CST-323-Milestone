package com.gcu.milestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan({"com.gcu"})
public class MilestoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilestoneApplication.class, args);
	}

}

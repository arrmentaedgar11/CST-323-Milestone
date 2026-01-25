package com.gcu.milestone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gcu.milestone"})
public class MilestoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilestoneApplication.class, args);
	}

}

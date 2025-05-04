package com.gcu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories("com.gcu.Repository")
public class RepositoryConfig {
	

	}
	



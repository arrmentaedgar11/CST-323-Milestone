package com.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authz -> authz
					.requestMatchers("/management/**", "/editWarranty/**", "/editClaimBusiness/**", "/createWarranty", "/addNewWarranty" ).hasRole("ADMIN")
					.requestMatchers("/claims/**", "/createClaim").hasAnyRole("USER")
					.requestMatchers("/", "/images/**", "/css/**", "/login", "/register").permitAll()
					.anyRequest().authenticated()
					)
			.formLogin(Customizer.withDefaults())
			.logout(Customizer.withDefaults())
			.exceptionHandling(exception -> exception
					.accessDeniedPage("/403"));
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password("{noop}user")
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("admin")
				.password("{noop}admin")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

}

package com.blog.blogging.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.blog.blogging.SecurityConfig.CustomUserDetailService;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	public  CustomUserDetailService customUserDetailService;
	

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            // Disable CSRF for APIs (optional: keep enabled if you use forms)
	            .csrf(csrf -> csrf.disable())

	            // Authorization rules
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/api/public/**").permitAll() // anyone can access
	                .requestMatchers("/api/auth/**").permitAll()   // login/register endpoints
	                .requestMatchers("/api/admin/**").hasRole("ADMIN") // only admin
	                .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // user or admin
	                .anyRequest().authenticated() // everything else needs login
	            )

	            // Default login form (you can replace with JWT later)
	            .formLogin(Customizer.withDefaults())

	            // HTTP Basic (Postman testing)
	            .httpBasic(Customizer.withDefaults());

	        return http.build();
	    }
	    
	    
	    @Bean
	    public AuthenticationManager authenticationManager(
	            HttpSecurity http,
	            PasswordEncoder passwordEncoder,
	            CustomUserDetailService userDetailsService) throws Exception {

	        AuthenticationManagerBuilder authManagerBuilder =
	                http.getSharedObject(AuthenticationManagerBuilder.class);

	        authManagerBuilder
	                .userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder);

	        return authManagerBuilder.build();
	    }
	    
		@Bean
		public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
		  
	}




package com.blog.blogging.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.blogging.exception.ResourceNotFoundException;
import com.blog.blogging.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	public UserRepo userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
	    return userRepo.findByEmailOrName(identifier)
	            .orElseThrow(() -> new UsernameNotFoundException(
	                "User not found with email or username: " + identifier
	            ));
	}


	
	

}

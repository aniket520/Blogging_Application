package com.blog.blogging.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogging.payload.LoginRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
	
	

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
	        return ResponseEntity.ok("✅ Login success");
	    }
	}




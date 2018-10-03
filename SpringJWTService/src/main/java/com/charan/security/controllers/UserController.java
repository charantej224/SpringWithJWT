package com.charan.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charan.security.models.UserDetails;
import com.charan.security.services.TokenAuthenticationService;
import com.charan.security.services.UserDetailsService;

@RestController
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	TokenAuthenticationService tokenService;
	
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody UserDetails userDetails) {
		try {
			userDetailsService.saveUser(userDetails);
			String token = tokenService.createToken(userDetails.getId());
			return ResponseEntity.ok(token);
		} catch(Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request failed");
		}
	
		
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<UserDetails> getUser(@RequestParam("id") Long id) {
		return ResponseEntity.ok(userDetailsService.getUser(id));
		
	}
	
	@GetMapping("/getSomeUser")
	public ResponseEntity<UserDetails> getUser() {
		return ResponseEntity.ok(userDetailsService.getUser(100L));
		
	}

}

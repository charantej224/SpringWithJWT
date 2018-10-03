package com.charan.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.security.models.UserDetails;
import com.charan.security.repository.UserDetailsRepository;



@Service
public class UserDetailsService {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	public void saveUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		userDetailsRepository.save(userDetails);
		
	}

	public UserDetails getUser(Long id) {
		// TODO Auto-generated method stub
		return userDetailsRepository.findOne(id);
	}
	
	
	
	
}

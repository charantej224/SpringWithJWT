package com.charan.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.charan.security.models.UserDetails;


public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
	
	

}

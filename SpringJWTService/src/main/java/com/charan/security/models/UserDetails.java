package com.charan.security.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="user_details")
public class UserDetails {
	
	@Id
	@JsonProperty("ID")
	@Column(name="id")
	private Long id;
	
	@JsonProperty("UserName")
	@Column(name="user_name")
	private String userName;
	
	@JsonProperty("UserPassword")
	@Column(name="user_password")
	private String userDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}

	
	
}

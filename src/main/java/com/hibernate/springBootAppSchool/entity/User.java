package com.hibernate.springBootAppSchool.entity;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

public class User {

	@Column(unique = true) 
	@NotNull
	@Email
	private String email;
	
	@Column(unique = true) 
	private String username;
	
	@Column
	private String password;
	
	@Transient 
	private String confirmPassword;
	
	//User Type: Admin, Teacher or Student. Access to application
	private String UserType;
}

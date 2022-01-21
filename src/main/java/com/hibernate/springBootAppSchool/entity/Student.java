package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import javax.xml.validation.*;

import javax.persistence.JoinColumn;

@Entity
public class Student implements Serializable{

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column 
	@NotNull
	private String CI;
	
	@Column
	@NotNull
	@Size(min = 5, max = 50)
	private String firstName;
	@Column 
	private String lastName;
	
	@Column 
	private String birthDate;
	
	@Column 
	private String Age;
	
	@Column 
	private String Phone;
	
	@Column 
	private String State;
	
	@Column 
	private String Municipality;
	
	@Column 
	private String Address;
	
	@Column 
	private String RegistrationForm;
	
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
	
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set roles;
	*/
	public Student() {	}
	
	public Student(Long id) {
		this.id = id;
	}       //Getters, Setters, HashCode, Equals & ToString Functions
}
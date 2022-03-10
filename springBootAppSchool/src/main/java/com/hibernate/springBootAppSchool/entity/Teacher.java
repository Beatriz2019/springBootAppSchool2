package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import javax.xml.validation.*;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable{

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column 
	@NotBlank
	private String CI;
	
	@Column
	@NotBlank
	@Size(min = 5, max = 50)
	private String firstName;
	@Column 
	@NotBlank
	private String lastName;
	
	@Column 
	@NotBlank
	private String Phone;
	
	@Column 
	@NotBlank
	private String Position;
	
	@Column 
	@NotBlank
	@Digits(integer=4, fraction=2)
	private String Salary;
	
	@Column 
	@NotBlank
	private String Course;
	
	@Column 
	private String ClassSchedule;
			
	@Column(unique = true) 
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Column(unique = true) 
	private String username;
	
	@NotBlank
	@Column
	private String password;
	
	@NotBlank
	@Transient 
	private String confirmPassword;
	
	@OneToMany(mappedBy = "Teacher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 private Set<Activity> activities;
	
	// Que columna en la tabla Teacher tiene la FK para el empleado
    @JoinColumn(name = "employee_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;
	/*
	 * Revisar ESTO OJO
	@OneToOne(mappedBy = "Teacher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Assignment assignment;
	*/
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set roles;
	*/
	public Teacher() {	}
	
	public Teacher(Long id) {
		this.id = id;
	}       //Getters, Setters, HashCode, Equals & ToString Functions
}
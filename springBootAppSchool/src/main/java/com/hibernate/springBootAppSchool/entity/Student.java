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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

import javax.xml.validation.*;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "Student")
public class Student implements Serializable{

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
	private String birthDate;
	
	@Column 
	private String Age;
	
	@Column 
	@NotBlank
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
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Column(unique = true) 
	private String username;
	
	@Column
	@NotBlank
	private String password;
	
	@Transient 
	@NotBlank
	private String confirmPassword;
	
	//FALTA CREAR TODOS LOS CAMPOS DE RELACIONES DE ESTUDIANTE
	//Student - level (Grado) (Many to One)
	 @ManyToOne()
	 @JoinColumn(name = "level_id")
	 private Level level;
	 
	 //@OneToOne(mappedBy = "Student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 //private Assignment assignment;
	 
	 // Un estudiante tiene un pago mensual
	 @OneToMany(mappedBy = "Student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 private  Set<StudentMonthlyPayment>  studentMonthlyPayment;
	 
	 @ManyToOne()
	 @JoinColumn(name = "StudentRepresentative_id", nullable=false)
	 private StudentRepresentative studentRepresentative;
	
	 // Un estudiante tiene una Inscripción
	  @OneToOne(mappedBy = "Student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 private Set<Inscription> inscription;
	 
	 @OneToMany(mappedBy = "Student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 private Set<Activity> activities;
	 
	
	  
	 
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
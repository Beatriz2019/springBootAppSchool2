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
public class Employee implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private String Type;
				
	@Column(unique = true) 
	@NotBlank
	@Email
	private String email;

	 // Un empleado es un profesor
	  @OneToOne(mappedBy = "Employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 private Set<Teacher> teacher;
	  
	// Un empleado tiene N pago empleado
	  @OneToMany(mappedBy = "Employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	  private  Set<PaymentEmployee> paymentEmployee;
	  
	// Un empleado paga N Servicios
		  @OneToMany(mappedBy = "Employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
		  private  Set<Service> service;
		  
		// Un empleado hace N pagos de mantenimientos
		  @OneToMany(mappedBy = "Employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
		  private  Set<Maintenance> maintenance;		  
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set roles;
	*/
	public Employee() {	}
	
	public Employee(Long id) {
		this.id = id;
	}       //Getters, Setters, HashCode, Equals & ToString Functions
}
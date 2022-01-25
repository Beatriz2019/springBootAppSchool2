package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;
import java.util.Date;
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
public class Inscription implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	// Id Payment
	private Long id;
	
	@Column 
	@NotBlank
	private String TransferNumber;
	
	@Column
	@NotBlank
	private Date date;
	
	@Column
	@Size(min= 10, max = 70)
	private String Bank;
	
	@Column 
	@NotBlank
	@Digits(integer=5, fraction=2)
	private String TotalBs;
	
	@Column 
	@NotBlank
	@Digits(integer=5, fraction=2)
	private String TotalDollar;
	
	@Column 
	private String TypeOfCurrency;
	
	@Column 
	//Valor del dólar del día de la inscripción
	private String DollarDayValue;
	
	@Column 
	@NotBlank
	//Forma de pago
	private String WayToPay;
	
	@Column 
	@NotBlank
	private String PdfForm;
		
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set roles;
	*/
	public Inscription() {	}
	
	public Inscription(Long id) {
		this.id = id;
	}       //Getters, Setters, HashCode, Equals & ToString Functions
}


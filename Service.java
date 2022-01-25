package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	// Id Maintenance
	private Long id;
	
	@Column 
	private String Service;
	
	//Total Bs Servicio pagado
	@Column 
	@NotBlank
	@Digits(integer=5, fraction=2)
	private String TotalBs;
	
	@Column
	@NotBlank
	private Date date;

}

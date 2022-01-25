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
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Maintenance implements Serializable {

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
	@NotBlank
	private Date date;
	
	@Column 
	@NotBlank
	private String JobDescription;
	
	@Column 
	@NotBlank
	private String Materials;
	
	@Column 
	@NotBlank
	private String TotalMaterials;
	
	//Total General Bs
	@Column 
	@NotBlank
	@Digits(integer=5, fraction=2)
	private String GrandTotalBs;
	
	//Total General Dólares
	@Column 
	@NotBlank
	@Digits(integer=5, fraction=2)
	private String GrandTotalDollars;

}

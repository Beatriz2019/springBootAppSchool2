package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

//Tabla Grado
public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	// Id Grado
	private Long id;
	
	@Column 
	@NotBlank
	private String Level;
	
	@Column 
	@NotBlank
	private String Section;
	
	
}

package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import org.hibernate.mapping.Set;

//Tabla Grado
@Entity
@Table(name = "Level")
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
	
	//Un Grado tiene N Estudiantes Esta es la entidad padre
	/* OJO Este tipo List se importa de Java.util */
	@OneToMany(mappedBy = "Level", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set students;	
}

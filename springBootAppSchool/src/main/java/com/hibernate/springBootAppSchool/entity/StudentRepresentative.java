package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


@Entity
//Representante
public class StudentRepresentative implements Serializable {

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
	@NotBlank
	private String occupation;

	@Column 
	@NotBlank
	private String educationalLevel;
	
	@Column 
	@NotBlank
	private String HomePhone;
	
	@Column 
	@NotBlank
	private String JobPhone;
	
	//Un Representante tiene muchos estudiantes en el colegio
	@OneToMany(mappedBy = "StudentRepresentative", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students;
	
	//Un Representante inscribe N estudiantes en el colegio
		@OneToMany(mappedBy = "StudentRepresentative", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Inscription> inscription;
	
	//Un Representante paga N mensualidad estudiantes
		@OneToMany(mappedBy = "StudentRepresentative", cascade = CascadeType.ALL, orphanRemoval = true)
	    //private List<StudentMonthlyPayment> studentMonthlyPayment;
		private Set<StudentMonthlyPayment> studentMonthlyPayment;
		
public StudentRepresentative() {	}
	
	public StudentRepresentative(Long id) {
		this.id = id;
	}       //Getters, Setters, HashCode, Equals & ToString Functions

}

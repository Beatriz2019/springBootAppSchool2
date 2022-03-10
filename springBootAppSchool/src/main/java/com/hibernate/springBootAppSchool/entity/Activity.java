package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Activity")
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8620680901704266525L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column 
	@NotBlank
	private String Name;
	
	@Column 
	@NotBlank
	private String Description;
	
	//Archivo Actividad
	@Column 
	private String ActivityForm;
	
	@ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;
	
	@ManyToOne()
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    // getters, setters, equals, hashCode
}
	 
	 

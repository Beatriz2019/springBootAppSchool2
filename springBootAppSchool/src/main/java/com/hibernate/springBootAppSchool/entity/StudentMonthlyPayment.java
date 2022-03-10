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
import javax.persistence.ManyToOne;
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
@Table(name = "StudentMonthlyPayment")
public class StudentMonthlyPayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	//Persona que transfiere
	private String TransferName;
	
	@Column 
	@NotBlank
	//Mes pagado
	private String MonthPaid;
	
	// Que columna en la tabla StudentMonthlyPayment tiene la FK para Student
	/*
    @JoinColumn(name = "student_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;
    */
     @ManyToOne()
	 @JoinColumn(name = "Student_id", nullable=false)
	 private Set<Student> student;
    
    //UMuchas mensualidades pueden ser pagadas por el mismo representante (si tiene varios estudiantes en el colegio)   
    @ManyToOne
    @JoinColumn(name="StudentRepresentative_id", nullable=false)
    private StudentRepresentative studentRepresentative;
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set roles;
	*/
	public StudentMonthlyPayment() {	}
	
	public StudentMonthlyPayment(Long id) {
		this.id = id;
	}       //Getters, Setters, HashCode, Equals & ToString Functions


}

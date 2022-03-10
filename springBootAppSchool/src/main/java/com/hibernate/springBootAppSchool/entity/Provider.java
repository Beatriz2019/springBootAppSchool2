package com.hibernate.springBootAppSchool.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Provider")
public class Provider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Empresa, rif o c.i, productos, monto en bs si aplicación monto si no monto en dólares , fecha , nota
	//Campo InsumosQueProvee
	//relacionar Proveedor con mantenimiento
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	// Id Payment
	private Long id;
	
	@Column 
	@NotBlank
	private String Company;
	
	@Column(unique = true) 
	@NotBlank
	@Size(min = 6, max = 9)
	private String RifCI;
	
	@Column
	@NotBlank
	private String Products;
	
	@Column 
	@NotBlank
	@Digits(integer=5, fraction=2)
	private String TotalBs;
	
	@Column 
	@NotBlank
	@Digits(integer=5, fraction=2)
	private String TotalDollar;
	
	@Column
	@NotBlank
	private Date date;
	
	// Campo Nota, para saber cuánto pagó en Bs y cuánto en $
	@Column 
	@NotBlank
	private String Annotation;

	//Productos que ofrece
	@Column 
	@NotBlank
	private String Supplies;
	
	 @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	    })
	    @JoinTable(
	            name = "provider_maintenance",
	            joinColumns = {@JoinColumn(name = "provider_id")},
	            inverseJoinColumns = {@JoinColumn(name = "maintenance_id")}
	    )
	    private Set<Maintenance> maintenances;
	
	 }

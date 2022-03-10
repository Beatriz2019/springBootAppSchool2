package com.hibernate.springBootAppSchool.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Assignment")
public class Assignment implements Serializable {
	
	//Relación Ternaria
    /* Relación Asigna entre las tablas: Estudiante, Actividad y Profesor
     * referente a la actividad que asigna el profesor  */ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5965717290286523502L;
	
    @Column(nullable = false, updatable = false)
    private Long StudentId;
    
    @Column(nullable = false, updatable = false)
    private Long ActivityId;
	
    @Column(nullable = false, updatable = false)
    private Long TeacherId;
    
	@Column
	@NotBlank
	//Fecha de asignación
	private Date AssigmentDate;
	
	@Column
	@NotBlank
	//Fecha de entrega de la asignación
	private Date DeliveryDate;
	
	@Column 
	@NotBlank
	@Digits(integer=2, fraction=2)
	//Nota del estudiante
	private String Qualification;
	
	/*
	 @ManyToOne
	    @JoinColumn(name = "StudentId", insertable = false, updatable = false)
	    private Student Student;
	    @ManyToOne
	    @JoinColumn(name = "ActivityId", insertable = false, updatable = false)
	    private Activity Activity;
	    @ManyToOne
	    @JoinColumn(name = "TeacherId", insertable = false, updatable = false)
	    private Teacher Teacher;
	    */
    // getters, setters, equals, hashCode
	
	    
	 // Que columna en la tabla Tuition tiene la FK
	    /*
	    @JoinColumn(name = "teacher_id")
	    @OneToOne(fetch = FetchType.LAZY)
	    private Teacher teacher;
	    */
	    /*
	    // Que columna en la tabla Tuition tiene la FK
	    @JoinColumn(name = "student_id")
	    @OneToOne(fetch = FetchType.LAZY)
	    private Student student;
	    */
	    
	public Assignment() {}
	
	public Assignment(Long StudentId, Long ActivityId, Long TeacherId) { } 
	 // getters, setters, equals, hashCode
	
	 
	
	/*
	 * ejemplo clase ternaria
	 * @Entity
public class Sale {
    @Embeddable
    public static class Pk implements Serializable {
        @Column(nullable = false, updatable = false)
        private Long soldById;

        @Column(nullable = false, updatable = false)
        private Long buyerId;

        @Column(nullable = false, updatable = false)
        private Long productId;

        public Pk() {}

        public Pk(Long soldById, Long buyerId, Long productId) { ... }

        // getters, setters, equals, hashCode
    }

    @EmbeddedId
    private Pk pk;

    @ManyToOne
    @JoinColumn(name = "SOLDBYID", insertable = false, updatable = false)
    private SaleAssistant soldBy;
    @ManyToOne
    @JoinColumn(name = "BUYERID", insertable = false, updatable = false)
    private Customer buyer;
    @ManyToOne
    @JoinColumn(name = "PRODUCTID", insertable = false, updatable = false)
    private Product product;

    // getters, setters, equals, hashCode
}
	 * */
	 

}

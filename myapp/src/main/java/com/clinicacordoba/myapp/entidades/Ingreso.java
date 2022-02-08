package com.clinicacordoba.myapp.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Ingresos")
public class Ingreso implements Serializable{

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ingreso_id;
	
	@Size(max=4)
	@Column(name = "Habitacion", nullable = false)
	private Long hab;
	
	@Size(max=4)
	@Column(name = "Cama", nullable = false)
	private Long cama;
	
	@Column(name = "Fecha_Ingreso", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecing;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;	
}
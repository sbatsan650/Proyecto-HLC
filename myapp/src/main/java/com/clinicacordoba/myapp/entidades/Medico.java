package com.clinicacordoba.myapp.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Medicos")
public class Medico implements Serializable{

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medico_id;
	
	@Size(max=8)
	@Column(name = "Nombre", nullable = false)
	private String name;
	
	@Size(max=18)
	@Column(name = "Apellidos", nullable = false)
	private String surname;
	
	@Size(max=9)
	@Column(name = "Telefono", nullable = false)
	private Long phone;
	
	@Size(max=8)
	@Column(name = "Especialidad", nullable = false)
	private String especialidad;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Ingreso> ingresos;
}

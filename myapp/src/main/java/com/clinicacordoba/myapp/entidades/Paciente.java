package com.clinicacordoba.myapp.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Pacientes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Paciente implements Serializable{

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paciente_id;
	
	@Size(max=8)
	@Column(name = "Nombre", nullable = false)
	private String name;
	
	@Size(max=18)
	@Column(name = "Apellidos", nullable = false)
	private String surname;
	
	@Size(max=15)
	@Column(name = "Direccion", nullable = false)
	private String address;
	
	@Size(max=15)
	@Column(name = "Provincia", nullable = false)
	private String province;
	
	@Size(max=5)
	@Column(name = "Codigo_Postal", nullable = false)
	private Long pc;
	
	@Size(max=9)
	@Column(name = "Telefono", nullable = false)
	private Long phone;
	
	@Column(name = "Fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecna;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Ingreso> ingresos;
}

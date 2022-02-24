package com.clinicacordoba.myapp.entidades;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ModeloPaciente {

	private Long paciente_id;
	
	private String name;

	private String surname;
	
	private String address;

	private String province;

	private Long pc;
	
	private Long phone;

	private String fecna;
	
	private List<Ingreso> ingresos;
}

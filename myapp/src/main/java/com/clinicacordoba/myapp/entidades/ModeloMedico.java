package com.clinicacordoba.myapp.entidades;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ModeloMedico {

	private Long medico_id;
	
	private String name;
	
	private String surname;
	
	private Long phone;
	
	private String especialidad;

	private List<Ingreso> ingresos;
}

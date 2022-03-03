package com.clinicacordoba.myapp.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ModeloIngreso{

	private Long ingreso_id;
	
	private Long hab;
	
	private Long cama;
	
	private String fecing;
	
	private String medicoId;
	
	private String pacienteId;	
}

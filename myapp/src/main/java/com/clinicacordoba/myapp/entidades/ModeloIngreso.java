package com.clinicacordoba.myapp.entidades;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ModeloIngreso{

	private Long ingreso_id;
	
	private Long hab;
	
	private Long cama;
	
	private Date fecing;
	
	private Medico medico;
	
	private Paciente paciente;	
}

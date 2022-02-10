package com.clinicacordoba.myapp.servicios;

import java.util.List;

import com.clinicacordoba.myapp.entidades.Paciente;

public interface PacienteServiceI {

	public List<Paciente> obtenerTodosLosPacientes();
	
	public Paciente obtenerPacientePorId(final Long paciente_id);
	
	public void eliminarPacientePorId(final Long paciente_id);
	
	public void aniadirPaciente(final Paciente paciente);
	
	public void actualizarPaciente(final Paciente paciente);
}

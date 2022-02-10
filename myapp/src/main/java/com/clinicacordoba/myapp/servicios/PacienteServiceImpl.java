package com.clinicacordoba.myapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicacordoba.myapp.entidades.Paciente;
import com.clinicacordoba.myapp.repositorio.PacienteRepositorio;

public class PacienteServiceImpl implements PacienteServiceI{

	@Autowired
	private PacienteRepositorio pacienteRepositorio;
	
	@Override
	public List<Paciente> obtenerTodosLosPacientes() {
		return pacienteRepositorio.findAll();
	}

	@Override
	public Paciente obtenerPacientePorId(Long paciente_id) {
		return pacienteRepositorio.getById(paciente_id);
	}

	@Override
	public void eliminarPacientePorId(Long paciente_id) {
		pacienteRepositorio.deleteById(paciente_id);
	}

	@Override
	public void aniadirPaciente(Paciente paciente) {
		pacienteRepositorio.save(paciente);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		pacienteRepositorio.save(paciente);
	}

}

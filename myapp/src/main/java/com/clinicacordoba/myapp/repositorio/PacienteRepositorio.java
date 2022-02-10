package com.clinicacordoba.myapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicacordoba.myapp.entidades.Paciente;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long>{
	
	void removeByPaciente(Paciente paciente);
}
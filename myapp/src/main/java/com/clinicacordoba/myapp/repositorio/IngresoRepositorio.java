package com.clinicacordoba.myapp.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.Paciente;

@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, Long>{
	
	List<Ingreso> findByMedico(Medico medico);
	
	List<Ingreso> findByPaciente(Paciente paciente);
}

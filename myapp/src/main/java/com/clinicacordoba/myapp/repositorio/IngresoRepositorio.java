package com.clinicacordoba.myapp.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicacordoba.myapp.entidades.Ingreso;

@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, Long>{
	
	List<Ingreso> findByMedicoId(Long medico_id);
	
	List<Ingreso> findByPacienteId(Long paciente_id);
	
	void removeByIngreso(Ingreso ingreso);
}

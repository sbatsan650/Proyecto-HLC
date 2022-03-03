package com.clinicacordoba.myapp.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.Paciente;

@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, Long>{
	
	/**
	 * Devuelve una lista con todos los ingresos de un medico
	 * @param medico Recibe un objeto Medico
	 * @return Lista con todos los ingresos de un medico
	 */
	List<Ingreso> findByMedico(Medico medico);
	
	/**
	 * Devuelve una lista con todos los ingresos de un paciente
	 * @param paciente Recibe un objeto Paciente
	 * @return Lista con todos los ingresos de un paciente
	 */
	List<Ingreso> findByPaciente(Paciente paciente);
}

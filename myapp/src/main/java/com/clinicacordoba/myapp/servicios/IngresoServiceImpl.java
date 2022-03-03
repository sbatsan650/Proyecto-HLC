package com.clinicacordoba.myapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.Paciente;
import com.clinicacordoba.myapp.repositorio.IngresoRepositorio;

@Service
public class IngresoServiceImpl implements IngresoServiceI{

	@Autowired
	private IngresoRepositorio ingresoRepositorio;
	
	/**
	 * Metodo que devuelve una lista de ingresos
	 * @return Lista con todos los ingresos
	 */
	@Override
	public List<Ingreso> obtenerTodosLosIngresos() {
		return ingresoRepositorio.findAll();
	}

	/**
	 * Metodo que devuelve un ingreso
	 * @param ingreso_id Tipo long recibido por parametro
	 * @return Devuelve un ingreso
	 */
	@Override
	public Ingreso obtenerIngresoPorId(Long ingreso_id) {
		return ingresoRepositorio.getById(ingreso_id);
	}

	/**
	 * Metodo que elimina un ingreso
	 * @param ingreso_id Tipo long recibido por parametro
	 * @return Devuelve un ingreso
	 */
	@Override
	public void eliminarIngresoPorId(Long ingreso_id) {
		ingresoRepositorio.deleteById(ingreso_id);
	}

	/**
	 * Metodo que añade un ingreso
	 * @param ingreso_id Tipo Ingreso recibido por parametro
	 * @return Devuelve un ingreso
	 */
	@Override
	public void aniadirIngreso(Ingreso ingreso) {
		ingresoRepositorio.save(ingreso);	
	}

	/**
	 * Metodo que actualiza un ingreso
	 * @param ingreso_id Tipo Ingreso recibido por parametro
	 * @return Devuelve un ingreso
	 */
	@Override
	public void actualizarIngreso(Ingreso ingreso) {
		ingresoRepositorio.save(ingreso);
	}

	/**
	 * Devuelve una lista con todos los ingresos de un paciente
	 * @param paciente Recibe un objeto Paciente
	 * @return Lista con todos los ingresos de un paciente
	 */
	@Override
	public List<Ingreso> obtenerIngresosPorPaciente(Paciente p) {		
		return ingresoRepositorio.findByPaciente(p);
	}

	/**
	 * Devuelve una lista con todos los ingresos de un medico
	 * @param medico Recibe un objeto Medico
	 * @return Lista con todos los ingresos de un medico
	 */
	@Override
	public List<Ingreso> obtenerIngresosPorMedico(Medico m) {
		return ingresoRepositorio.findByMedico(m);
	}

}

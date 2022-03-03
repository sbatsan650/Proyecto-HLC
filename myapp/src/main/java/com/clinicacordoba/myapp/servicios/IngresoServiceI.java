package com.clinicacordoba.myapp.servicios;

import java.util.List;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.Paciente;

public interface IngresoServiceI {
	
	/**
	 * Metodo que devuelve una lista de ingresos
	 * @return Lista con todos los ingresos
	 */
	public List<Ingreso> obtenerTodosLosIngresos();
	
	/**
	 * Metodo que devuelve un ingreso
	 * @param ingreso_id Tipo long recibido por parametro
	 * @return Devuelve un ingreso
	 */
	public Ingreso obtenerIngresoPorId(final Long ingreso_id);
	
	/**
	 * Metodo que elimina un ingreso
	 * @param ingreso_id Tipo long recibido por parametro
	 * @return Devuelve un ingreso
	 */
	public void eliminarIngresoPorId(final Long ingreso_id);
	
	/**
	 * Metodo que añade un ingreso
	 * @param ingreso_id Tipo Ingreso recibido por parametro
	 * @return Devuelve un ingreso
	 */
	public void aniadirIngreso(final Ingreso ingreso);
	
	/**
	 * Metodo que actualiza un ingreso
	 * @param ingreso_id Tipo Ingreso recibido por parametro
	 * @return Devuelve un ingreso
	 */
	public void actualizarIngreso(final Ingreso ingreso);
	
	/**
	 * Devuelve una lista con todos los ingresos de un paciente
	 * @param paciente Recibe un objeto Paciente
	 * @return Lista con todos los ingresos de un paciente
	 */
	public List<Ingreso> obtenerIngresosPorPaciente(final Paciente paciente);
	
	/**
	 * Devuelve una lista con todos los ingresos de un medico
	 * @param medico Recibe un objeto Medico
	 * @return Lista con todos los ingresos de un medico
	 */
	public List<Ingreso> obtenerIngresosPorMedico(final Medico medico);
}

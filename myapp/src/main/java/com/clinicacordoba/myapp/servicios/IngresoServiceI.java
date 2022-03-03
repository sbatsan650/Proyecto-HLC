package com.clinicacordoba.myapp.servicios;

import java.util.List;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.Paciente;

public interface IngresoServiceI {
	
	public List<Ingreso> obtenerTodosLosIngresos();
	
	public Ingreso obtenerIngresoPorId(final Long ingreso_id);
	
	public void eliminarIngresoPorId(final Long ingreso_id);
	
	public void aniadirIngreso(final Ingreso ingreso);
	
	public void actualizarIngreso(final Ingreso ingreso);
	
	public List<Ingreso> obtenerIngresosPorPaciente(final Paciente paciente);
	
	public List<Ingreso> obtenerIngresosPorMedico(final Medico medico);
}

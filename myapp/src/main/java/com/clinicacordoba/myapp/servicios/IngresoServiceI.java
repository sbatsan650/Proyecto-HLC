package com.clinicacordoba.myapp.servicios;

import java.util.List;

import com.clinicacordoba.myapp.entidades.Ingreso;

public interface IngresoServiceI {
	
	public List<Ingreso> obtenerTodosLosIngresos();
	
	public Ingreso obtenerIngresoPorId(final Long ingreso_id);
	
	public void eliminarIngresoPorId(final Long ingreso_id);
	
	public void aniadirIngreso(final Ingreso ingreso);
	
	public void actualizarIngreso(final Ingreso ingreso);
}

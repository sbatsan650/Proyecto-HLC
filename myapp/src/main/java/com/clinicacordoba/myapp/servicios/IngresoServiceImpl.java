package com.clinicacordoba.myapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.repositorio.IngresoRepositorio;

public class IngresoServiceImpl implements IngresoServiceI{

	@Autowired
	private IngresoRepositorio ingresoRepositorio;
	
	@Override
	public List<Ingreso> obtenerTodosLosIngresos() {
		return ingresoRepositorio.findAll();
	}

	@Override
	public Ingreso obtenerIngresoPorId(Long ingreso_id) {
		return ingresoRepositorio.getById(ingreso_id);
	}

	@Override
	public void eliminarIngresoPorId(Long ingreso_id) {
		ingresoRepositorio.deleteById(ingreso_id);
	}

	@Override
	public void aniadirIngreso(Ingreso ingreso) {
		ingresoRepositorio.save(ingreso);	
	}

	@Override
	public void actualizarIngreso(Ingreso ingreso) {
		ingresoRepositorio.save(ingreso);
	}

}

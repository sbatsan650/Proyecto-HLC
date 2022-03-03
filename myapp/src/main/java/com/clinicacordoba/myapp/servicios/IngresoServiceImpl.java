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

	@Override
	public List<Ingreso> obtenerIngresosPorPaciente(Paciente p) {		
		return ingresoRepositorio.findByPaciente(p);
	}

	@Override
	public List<Ingreso> obtenerIngresosPorMedico(Medico m) {
		return ingresoRepositorio.findByMedico(m);
	}

}

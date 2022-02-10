package com.clinicacordoba.myapp.servicios;

import java.util.List;

import com.clinicacordoba.myapp.entidades.Medico;

public interface MedicoServiceI {

	public List<Medico> obtenerTodosLosMedicos();
	
	public Medico obtenerMedicoPorId(final Long medico_id);
	
	public void eliminarMedicoPorId(final Long medico_id);
	
	public void aniadirMedico(final Medico Medico);
	
	public void actualizarMedico(final Medico medico);
}

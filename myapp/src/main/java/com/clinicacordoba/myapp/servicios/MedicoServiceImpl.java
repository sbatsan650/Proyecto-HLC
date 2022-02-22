package com.clinicacordoba.myapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.repositorio.MedicoRepositorio;

@Service
public class MedicoServiceImpl implements MedicoServiceI{

	@Autowired
	private MedicoRepositorio medicoRepositorio;

	@Override
	public List<Medico> obtenerTodosLosMedicos() {
		return medicoRepositorio.findAll();
	}

	@Override
	public Medico obtenerMedicoPorId(Long medico_id) {
		return medicoRepositorio.getById(medico_id);
	}

	@Override
	public void eliminarMedicoPorId(Long medico_id) {
		medicoRepositorio.deleteById(medico_id);		
	}

	@Override
	public void aniadirMedico(Medico Medico) {
		medicoRepositorio.save(Medico);
	}

	@Override
	public void actualizarMedico(Medico medico) {
		medicoRepositorio.save(medico);
	}
}

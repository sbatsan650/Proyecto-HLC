package com.clinicacordoba.myapp.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinicacordoba.myapp.entidades.Paciente;
import com.clinicacordoba.myapp.servicios.PacienteServiceI;

@Controller
public class PacienteController {

	@Autowired
	private PacienteServiceI pacienteServiceI;
	
	@GetMapping("/showPacienteView")
	public String mostrarPacientes(Model model) {

		// Obtención de vehículos
		final List<Paciente> listaPacientes = pacienteServiceI.obtenerTodosLosPacientes();

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", listaPacientes);
		model.addAttribute("btnDropPacienteEnabled", Boolean.FALSE);
		model.addAttribute("btnUpdatePacienteEnabled", Boolean.FALSE);

		return "showPaciente";
	}
	
	@PostMapping("/actDropPaciente")
	public String eliminarPaciente(@RequestParam String pacienteId, Model model) {

		// Eliminación de paciente
		pacienteServiceI.eliminarPacientePorId(Long.valueOf(pacienteId));

		return "redirect:showPacienteView";

	}
	
	@PostMapping("/actSearchPaciente")
	public String submitBuscarCocheForm(@ModelAttribute Paciente searchedPaciente, Model model) throws Exception {

		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		
		List<Paciente> listaTodoslosPacientes = pacienteServiceI.obtenerTodosLosPacientes();
		
		final long pacienteId = searchedPaciente.getPaciente_id();
		final String pacienteNombre = searchedPaciente.getName();
		final String pacienteApellido = searchedPaciente.getSurname();
		final String pacienteDireccion = searchedPaciente.getAddress();
		final String pacienteProvincia = searchedPaciente.getProvince();
		final Long pacienteCP = searchedPaciente.getPc();
		final Long pacienteTelefono = searchedPaciente.getPhone();
		final Date pacienteFecha = searchedPaciente.getFecna();

		if (StringUtils.hasText(String.valueOf(pacienteId))) {

			// Búsqueda por matrícula
			final Paciente paciente = pacienteServiceI.obtenerPacientePorId(pacienteId);

			if (paciente != null) {
				listaPacientes.add(paciente);
			}
		} else if (StringUtils.hasText(pacienteNombre)) {

			// Búsqueda por nombre
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getName().equalsIgnoreCase(pacienteNombre)) {
					listaPacientes.add(p);
				}
			}
		} else if (StringUtils.hasText(pacienteApellido)) {

			// Búsqueda por apellido
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getSurname().equalsIgnoreCase(pacienteApellido)) {
					listaPacientes.add(p);
				}
			}
		} else if(StringUtils.hasText(pacienteDireccion)) {
		
			// Búsqueda por direccion
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getAddress().equalsIgnoreCase(pacienteDireccion)) {
					listaPacientes.add(p);
				}
			}
		} else if(StringUtils.hasText(pacienteProvincia)) {
		
			// Búsqueda por provincia
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getProvince().equalsIgnoreCase(pacienteProvincia)) {
					listaPacientes.add(p);
				}
			}
		} else if(StringUtils.hasText(String.valueOf(pacienteCP))) {
		
			// Búsqueda por codigo postal
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getPc() == pacienteCP) {
					listaPacientes.add(p);
				}
			}
		} else if(StringUtils.hasText(String.valueOf(pacienteTelefono))) {
		
			// Búsqueda por telefono
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getPhone() == pacienteTelefono) {
					listaPacientes.add(p);
				}
			}
		} else if(StringUtils.hasText(String.valueOf(pacienteFecha))) {
		
			// Búsqueda por fecha
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getFecna().compareTo(pacienteFecha) == 0) {
					listaPacientes.add(p);
				}
			}
		} else {
			throw new Exception("Parámetros de búsqueda erróneos.");
		}

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", listaPacientes);
		model.addAttribute("btnDropCarEnabled", Boolean.FALSE);
		model.addAttribute("btnUpdatePacienteEnabled", Boolean.FALSE);

		return "showPaciente";

	}
}

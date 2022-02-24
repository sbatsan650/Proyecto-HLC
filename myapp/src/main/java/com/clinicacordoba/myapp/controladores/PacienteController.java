package com.clinicacordoba.myapp.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinicacordoba.myapp.entidades.ModeloPaciente;
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
	public String submitBuscarCocheForm(@ModelAttribute ModeloPaciente searchedPaciente, Model model) throws Exception {

		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		List<Paciente> listaTodoslosPacientes = pacienteServiceI.obtenerTodosLosPacientes();
		
		final long pacienteId = searchedPaciente.getPaciente_id()==null?9999:searchedPaciente.getPaciente_id();
		final String pacienteNombre = searchedPaciente.getName();
		final String pacienteApellido = searchedPaciente.getSurname();
		final String pacienteDireccion = searchedPaciente.getAddress();
		final String pacienteProvincia = searchedPaciente.getProvince();
		final Long pacienteCP = searchedPaciente.getPc();
		final Long pacienteTelefono = searchedPaciente.getPhone();
		final Date pacienteFecha = !searchedPaciente.getFecna().isEmpty()?dateFormat.parse(searchedPaciente.getFecna()):null;

		if (pacienteId != 9999 /*StringUtils.hasText(String.valueOf(pacienteId))*/) {
			final Paciente paciente;

			// Búsqueda por matrícula
			paciente = pacienteServiceI.obtenerPacientePorId(pacienteId);

			if (paciente != null) {
				if(!listaPacientes.contains(paciente)) {
					listaPacientes.add(paciente);
				}
			}
		} 
		
		if (StringUtils.hasText(pacienteNombre)) {

			// Búsqueda por nombre
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getName().equalsIgnoreCase(pacienteNombre)) {
					if(!listaPacientes.contains(p)) {
						listaPacientes.add(p);
					}
				}
			}
		} 
		
		if (StringUtils.hasText(pacienteApellido)) {

			// Búsqueda por apellido
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getSurname().equalsIgnoreCase(pacienteApellido)) {
					if(!listaPacientes.contains(p)) {
						listaPacientes.add(p);
					}
				}
			}
		} 
		
		if(StringUtils.hasText(pacienteDireccion)) {
		
			// Búsqueda por direccion
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getAddress().equalsIgnoreCase(pacienteDireccion)) {
					if(!listaPacientes.contains(p)) {
						listaPacientes.add(p);
					}
				}
			}
		}
		
		if(StringUtils.hasText(pacienteProvincia)) {
		
			// Búsqueda por provincia
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getProvince().equalsIgnoreCase(pacienteProvincia)) {
					if(!listaPacientes.contains(p)) {
						listaPacientes.add(p);
					}
				}
			}
		} 
		
		if(StringUtils.hasText(String.valueOf(pacienteCP))) {
		
			// Búsqueda por codigo postal
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getPc().toString().equalsIgnoreCase(String.valueOf(pacienteCP))) {
					if(!listaPacientes.contains(p)) {
						listaPacientes.add(p);
					}
				}
			}
		}
		
		if(StringUtils.hasText(String.valueOf(pacienteTelefono))) {
			System.out.println(pacienteTelefono);
			// Búsqueda por telefono
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getPhone().toString().equalsIgnoreCase(String.valueOf(pacienteTelefono))) {
					if(!listaPacientes.contains(p)) {
						listaPacientes.add(p);
					}
				}
			}
		}
		
		if(pacienteFecha!=null) {
			// Búsqueda por fecha
			for(Paciente p : listaTodoslosPacientes) {
				if(p.getFecna().compareTo(pacienteFecha) == 0) {
					if(!listaPacientes.contains(p)) {
						listaPacientes.add(p);
					}
				}
			}
		} /*else {
			throw new Exception("Parámetros de búsqueda erróneos.");
		}*/

		if(!listaPacientes.isEmpty()) {
			// Carga de datos al modelo
			model.addAttribute("PacientesListView", listaPacientes);
			model.addAttribute("btnDropPacienteEnabled", Boolean.FALSE);
			model.addAttribute("btnUpdatePacienteEnabled", Boolean.FALSE);
		} else {
			throw new Exception("No se han encontrado pacientes.");
		}

		return "showPaciente";

	}
}

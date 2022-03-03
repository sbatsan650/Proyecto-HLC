package com.clinicacordoba.myapp.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinicacordoba.myapp.entidades.ModeloPaciente;
import com.clinicacordoba.myapp.entidades.Paciente;
import com.clinicacordoba.myapp.servicios.PacienteServiceI;

/**
 * Clase controladora de paciente
 * @author Sergio
 *
 */
@Controller
public class PacienteController {

	@Autowired
	private PacienteServiceI pacienteServiceI;
	
	/**
	 * Metodo que muestra todos los pacientes
	 * @param model
	 * @return Redirige a la pagina deseada 
	 */
	@GetMapping("/showPacienteView")
	public String mostrarPacientes(Model model) {

		// Obtención de pacientes
		final List<Paciente> listaPacientes = pacienteServiceI.obtenerTodosLosPacientes();

		// Carga de datos al modelo
		model.addAttribute("PacientesListView", listaPacientes);
		model.addAttribute("btnDropPacienteEnabled", Boolean.FALSE);
		model.addAttribute("btnUpdatePacienteEnabled", Boolean.FALSE);

		return "showPaciente";
	}
	
	/**
	 * Metodo que elimina un paciente por Id
	 * @param pacienteId
	 * @param model
	 * @return Redirige a la pagina deseada 
	 */
	@PostMapping("/actDropPaciente")
	public String eliminarPaciente(@RequestParam String pacienteId, Model model) {

		// Eliminación de paciente
		pacienteServiceI.eliminarPacientePorId(Long.valueOf(pacienteId));

		return "redirect:showPacienteView";

	}
	
	/**
	 * Metodo que busca un paciente por tipo
	 * @param searchedPaciente Paciente recibido por parametro
	 * @param model
	 * @return Redirige a la pagina deseada 
	 * @throws Exception Devuelve una exception en caso de error
	 */
	@PostMapping("/actSearchPaciente")
	public String submitBuscarPacienteForm(@ModelAttribute ModeloPaciente searchedPaciente, Model model) throws Exception {

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

			// Búsqueda por id
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

	/**
	 * Metodo de añadir paciente
	 * @param paciente Objeto Paciente recibido por parametro
	 * @param result
	 * @return Redirige a la pagina deseada 
	 * @throws Exception Devuelve una excepcion en caso de error
	 */
	@PostMapping("/actAddPaciente")
	private String aniadirPaciente(@Valid @ModelAttribute ModeloPaciente paciente, BindingResult result) throws Exception {
		
		Paciente p = new Paciente();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = dateFormat.parse(paciente.getFecna());

		p.setName(paciente.getName());
		p.setSurname(paciente.getSurname());
		p.setAddress(paciente.getAddress());
		p.setProvince(paciente.getProvince());
		p.setPc(paciente.getPc());
		p.setPhone(paciente.getPhone());
		p.setFecna(fecha);
		
		if (result.hasErrors()) {
			throw new Exception("Parámetros erróneos");
		} else {
			// Se añade el nuevo paciente
			pacienteServiceI.aniadirPaciente(p);
		}

		return "redirect:showPacienteView";
	}

	/**
	 * Metodo para editar un paciente
	 * @param pacienteId Id de paciente recibido por parametro
	 * @param model
	 * @return Redirige a la pagina deseada 
	 */
	@GetMapping("/updatePacienteView")
	public String editarPacientes(String pacienteId, Model model) {

		// Obtencion del paciente
		Paciente p = pacienteServiceI.obtenerPacientePorId(Long.parseLong(pacienteId));

		// Carga de datos
		model.addAttribute("paciente_id", p.getPaciente_id());
		model.addAttribute("name", p.getName());
		model.addAttribute("surname", p.getSurname());
		model.addAttribute("pc", p.getPc());
		model.addAttribute("address", p.getAddress());
		model.addAttribute("fecna", p.getFecna());
		model.addAttribute("province", p.getProvince());
		model.addAttribute("phone", p.getPhone());

		return "updatePaciente";
	}
	
	/**
	 * Metodo que edita al paciente
	 * @param paciente Paciente recibido por parametro
	 * @param result
	 * @return Redirige a la pagina deseada 
	 * @throws Exception
	 */
	@GetMapping("/actUpdatePaciente")
	public String editarPaciente(@Valid @ModelAttribute ModeloPaciente paciente, BindingResult result) throws Exception {

		Paciente p = new Paciente();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = dateFormat.parse(paciente.getFecna());

		p.setPaciente_id(paciente.getPaciente_id());
		p.setName(paciente.getName());
		p.setSurname(paciente.getSurname());
		p.setAddress(paciente.getAddress());
		p.setProvince(paciente.getProvince());
		p.setPc(paciente.getPc());
		p.setPhone(paciente.getPhone());
		p.setFecna(fecha);
		
		if (result.hasErrors()) {
			throw new Exception("Parámetros erróneos");
		} else {
			pacienteServiceI.actualizarPaciente(p);
		}

		return "redirect:showPacienteView";
	}
}

package com.clinicacordoba.myapp.controladores;

import java.util.ArrayList;
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

import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.ModeloMedico;
import com.clinicacordoba.myapp.servicios.MedicoServiceI;

/**
 * Clase controladora de Medico
 * @author Sergio
 *
 */
@Controller
public class MedicoController {

	@Autowired
	private MedicoServiceI medicoServiceI;
	
	/**
	 * Muestra todos los medicos
	 * @param model
	 * @return Redirige a la pagina deseada 
	 */
	@GetMapping("/showMedicoView")
	public String mostrarMedicos(Model model) {

		// Obtención de medicos
		final List<Medico> listaMedicos = medicoServiceI.obtenerTodosLosMedicos();

		// Carga de datos al modelo
		model.addAttribute("MedicosListView", listaMedicos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);
		model.addAttribute("btnUpdateMedicoEnabled", Boolean.FALSE);

		return "showMedico";
	}
	
	/**
	 * Elimina un medico por id
	 * @param medicoId Recibe un id de medico de la vista
	 * @param model
	 * @return Redirige a la pagina deseada 
	 */
	@PostMapping("/actDropMedico")
	public String eliminarMedico(@RequestParam String medicoId, Model model) {

		// Eliminación de medico
		medicoServiceI.eliminarMedicoPorId(Long.valueOf(medicoId));

		return "redirect:showMedicoView";

	}
	
	/**
	 * Metodo para buscar un medico por tipo
	 * @param searchedMedico Objeto ModeloMedico recibido de la vista
	 * @param model
	 * @return Redirige a la pagina deseada 
	 * @throws Exception En caso de error devuelve una excepcion
	 */
	@PostMapping("/actSearchMedico")
	public String submitBuscarMedicoForm(@ModelAttribute ModeloMedico searchedMedico, Model model) throws Exception {

		List<Medico> listaMedicos = new ArrayList<Medico>();
				
		List<Medico> listaTodoslosMedicos = medicoServiceI.obtenerTodosLosMedicos();
		
		final String medicoNombre = searchedMedico.getName();
		final String medicoApellido = searchedMedico.getSurname();
		final Long medicoTelefono = searchedMedico.getPhone();
		final String medicoEspecialidad = searchedMedico.getEspecialidad();
		
		if (StringUtils.hasText(medicoNombre)) {

			// Búsqueda por nombre
			for(Medico p : listaTodoslosMedicos) {
				if(p.getName().equalsIgnoreCase(medicoNombre)) {
					if(!listaMedicos.contains(p)) {
						listaMedicos.add(p);
					}
				}
			}
		} 
		
		if (StringUtils.hasText(medicoApellido)) {

			// Búsqueda por apellido
			for(Medico p : listaTodoslosMedicos) {
				if(p.getSurname().equalsIgnoreCase(medicoApellido)) {
					if(!listaMedicos.contains(p)) {
						listaMedicos.add(p);
					}
				}
			}
		} 
		
		if(StringUtils.hasText(String.valueOf(medicoTelefono))) {
		
			// Búsqueda por Telefono
			for(Medico p : listaTodoslosMedicos) {
				if(p.getPhone().toString().equalsIgnoreCase(String.valueOf(medicoTelefono))) {
					if(!listaMedicos.contains(p)) {
						listaMedicos.add(p);
					}
				}
			}
		}
		
		if(StringUtils.hasText(medicoEspecialidad)) {
		
			// Búsqueda por especialidad
			for(Medico p : listaTodoslosMedicos) {
				if(p.getEspecialidad().equalsIgnoreCase(medicoEspecialidad)) {
					if(!listaMedicos.contains(p)) {
						listaMedicos.add(p);
					}
				}
			}
		} 

		if(!listaMedicos.isEmpty()) {
			// Carga de datos al modelo
			model.addAttribute("MedicosListView", listaMedicos);
			model.addAttribute("btnDropPacienteEnabled", Boolean.FALSE);
			model.addAttribute("btnUpdatePacienteEnabled", Boolean.FALSE);
		} else {
			throw new Exception("No se han encontrado pacientes.");
		}
	 	
		return "showMedico";

	}

	/**
	 * Metodo para añadir un medico
	 * @param medico
	 * @param result
	 * @return Redirige a la pagina deseada 
	 * @throws Exception Devuelve una excepcion en caso de error
	 */
	@PostMapping("/actAddMedico")
	private String aniadirMedico(@Valid @ModelAttribute ModeloMedico medico, BindingResult result) throws Exception {
		
		Medico p = new Medico();

		p.setName(medico.getName());
		p.setSurname(medico.getSurname());
		p.setPhone(medico.getPhone());
		p.setEspecialidad(medico.getEspecialidad());
		
		if (result.hasErrors()) {
			throw new Exception("Parámetros erróneos");
		} else {
			// Se añade el nuevo medico
			medicoServiceI.aniadirMedico(p);
		}

		return "redirect:showMedicoView";
	}

	/**
	 * Metodo para editar un medico
	 * @param medicoId Id de medico recibido por la vista
	 * @param model
	 * @return Redirige a la pagina deseada 
	 */
	@GetMapping("/updateMedicoView")
	public String editarMedicos(String medicoId, Model model) {

		// Obtencion del medico
		Medico p = medicoServiceI.obtenerMedicoPorId(Long.parseLong(medicoId));

		// Carga de datos
		model.addAttribute("medico_id", p.getMedico_id());
		model.addAttribute("name", p.getName());
		model.addAttribute("surname", p.getSurname());
		model.addAttribute("especialidad", p.getEspecialidad());
		model.addAttribute("phone", p.getPhone());

		return "updateMedico";
	}
	
	/**
	 * Metodo que edita el medico deseado
	 * @param medico Objeto medico recibido por parametro
	 * @param result
	 * @return Redirige a la pagina deseada 
	 * @throws Exception
	 */
	@GetMapping("/actUpdateMedico")
	public String editarMedico(@Valid @ModelAttribute Medico medico, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			throw new Exception("Parámetros erróneos");
		} else {
			medicoServiceI.actualizarMedico(medico);
		}

		return "redirect:showMedicoView";
	}
}

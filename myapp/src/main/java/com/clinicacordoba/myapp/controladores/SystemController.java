package com.clinicacordoba.myapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase controladora del sistema
 * @author Sergio
 *
 */
@Controller
@RequestMapping("*")
public class SystemController {

		/**
		 * Capta cualquier solicitud
		 * @return redirige al index
		 */
		@GetMapping
		public String showIndex() {
			return "index";
		}
		
		/**
		 * Redirecciona al controlador de gestión de pacientes
		 * @return redirige a la vista de pacientes
		 */
		@GetMapping("/PacienteView")
		public String redirectToPacienteDealershipController() {
			return "redirect:showPacienteView";
		}
		
		/**
		 * Redirecciona a la plantilla de búsqueda
		 * @return Redirecciona a la plantilla de búsqueda
		 */
		@GetMapping("/searchPacienteByView")
		public String redirectToPacienteSearchByTemplate() {
			return "searchPacienteBy";
		}
		
		/**
		 * Redirecciona a la plantilla de insercción
		 * @return Redirecciona a la plantilla de insercción
		 */
		@GetMapping("/newPacienteView")
		public String redirectToNewPacienteTemplate() {
			return "newPaciente";
		}
		
		/**
		 * Redirecciona al controlador de gestión de medicos
		 * @return Redirecciona al controlador de gestión de medicos
		 */
		@GetMapping("/MedicoView")
		public String redirectToMedicoDealershipController() {
			return "redirect:showMedicoView";
		}
		
		/**
		 * Redirecciona a la plantilla de búsqueda
		 * @return Redirecciona a la plantilla de búsqueda
		 */
		@GetMapping("/searchMedicoByView")
		public String redirectToMedicoSearchByTemplate() {
			return "searchMedicoBy";
		}
		
		/**
		 * Redirecciona a la plantilla de insercción
		 * @return Redirecciona a la plantilla de insercción
		 */
		@GetMapping("/newMedicoView")
		public String redirectToNewMedicoTemplate() {
			return "newMedico";
		}
		 
		/**
		 * Redirecciona al controlador de gestión de ingresos
		 * @return Redirecciona al controlador de gestión de ingresos
		 */
		@GetMapping("/IngresoView")
		public String redirectToIngresoDealershipController() {
			return "redirect:showIngresoView";
		}
		
		/**
		 * Redirecciona a la plantilla de búsqueda
		 * @return Redirecciona a la plantilla de búsqueda
		 */
		@GetMapping("/searchIngresoByView")
		public String redirectToIngresoSearchByTemplate() {
			return "searchIngresoBy";
		}
		
		/**
		 * Redirecciona a la plantilla de insercción
		 * @return Redirecciona a la plantilla de insercción
		 */
		@GetMapping("/newIngresoView")
		public String redirectToNewIngresoTemplate() {
			return "newIngreso";
		}
		
		/**
		 * Redirecciona a la plantilla de busqueda por paciente
		 * @return Redirecciona a la plantilla de busqueda por paciente
		 */
		@GetMapping("/searchIngresoPacByView")
		public String redirectToIngresoPacienteController() {
			return "redirect:showIngresosPacientes";
		}
		
		/**
		 * Redirecciona a la plantilla de busqueda por paciente
		 * @return Redirecciona a la plantilla de busqueda por paciente
		 */
		@GetMapping("/searchIngresoMedByView")
		public String redirectToIngresoMedicoController() {
			return "redirect:showIngresosMedicos";
		}
}

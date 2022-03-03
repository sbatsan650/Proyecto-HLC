package com.clinicacordoba.myapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {

	//Capta cualquier solicitud
		@GetMapping
		public String showIndex() {
			return "index";
		}
		
		//Redirecciona al controlador de gestión de pacientes
		@GetMapping("/PacienteView")
		public String redirectToPacienteDealershipController() {
			return "redirect:showPacienteView";
		}
		
		//Redirecciona a la plantilla de búsqueda
		@GetMapping("/searchPacienteByView")
		public String redirectToPacienteSearchByTemplate() {
			return "searchPacienteBy";
		}
		
		//Redirecciona a la plantilla de insercción
		@GetMapping("/newPacienteView")
		public String redirectToNewPacienteTemplate() {
			return "newPaciente";
		}
		
		//Redirecciona al controlador de gestión de medicos
		@GetMapping("/MedicoView")
		public String redirectToMedicoDealershipController() {
			return "redirect:showMedicoView";
		}
		
		//Redirecciona a la plantilla de búsqueda
		@GetMapping("/searchMedicoByView")
		public String redirectToMedicoSearchByTemplate() {
			return "searchMedicoBy";
		}
		
		//Redirecciona a la plantilla de insercción
		@GetMapping("/newMedicoView")
		public String redirectToNewMedicoTemplate() {
			return "newMedico";
		}
		
		@GetMapping("/IngresoView")
		public String redirectToIngresoDealershipController() {
			return "redirect:showIngresoView";
		}
		
		//Redirecciona a la plantilla de búsqueda
		@GetMapping("/searchIngresoByView")
		public String redirectToIngresoSearchByTemplate() {
			return "searchIngresoBy";
		}
		
		//Redirecciona a la plantilla de insercción
		@GetMapping("/newIngresoView")
		public String redirectToNewIngresoTemplate() {
			return "newIngreso";
		}
		
		@GetMapping("/searchIngresoPacByView")
		public String redirectToIngresoPacienteController() {
			return "redirect:showIngresosPacientes";
		}
		
		@GetMapping("/searchIngresoMedByView")
		public String redirectToIngresoMedicoController() {
			return "redirect:showIngresosMedicos";
		}
}

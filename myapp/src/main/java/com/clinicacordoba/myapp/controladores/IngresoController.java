package com.clinicacordoba.myapp.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.ModeloIngreso;
import com.clinicacordoba.myapp.entidades.Paciente;
import com.clinicacordoba.myapp.servicios.IngresoServiceI;
import com.clinicacordoba.myapp.servicios.MedicoServiceI;
import com.clinicacordoba.myapp.servicios.PacienteServiceI;

@Controller
public class IngresoController {

	@Autowired
	private IngresoServiceI ingresoServiceI;
	@Autowired
	private MedicoServiceI medicoServiceI;
	@Autowired
	private PacienteServiceI pacienteServiceI;
	
	@GetMapping("/showIngresoView")
	public String mostrarIngresos(Model model) {
		// Obtención de ingresos
		final List<Ingreso> listaIngresos = ingresoServiceI.obtenerTodosLosIngresos();

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngreso";
	}
	
	@PostMapping("/actDropIngreso")
	public String eliminarIngreso(@RequestParam String ingresoId, Model model) {

		// Eliminación de ingreso
		ingresoServiceI.eliminarIngresoPorId(Long.valueOf(ingresoId));

		return "redirect:showIngresoView";
	}

	@PostMapping("/actAddIngreso")
	private String aniadirIngreso(@Valid @ModelAttribute ModeloIngreso Ingreso, BindingResult result)
			throws Exception {

		List<Ingreso> ingresos = ingresoServiceI.obtenerTodosLosIngresos(); 
		List<Paciente> pacientes = pacienteServiceI.obtenerTodosLosPacientes();
		List<Medico> medicos = medicoServiceI.obtenerTodosLosMedicos();
		
		SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
		Date fecing = dateF.parse(Ingreso.getFecing());

		boolean encontrado = false;
		
		for(Medico med : medicos) {
			if(Ingreso.getMedicoId().equalsIgnoreCase(String.valueOf(med.getMedico_id()))) {
				encontrado = true;
			}
		}
		
		if(!encontrado)
			throw new Exception("No se ha encontrado un medico con el ID: " + Ingreso.getMedicoId());
		
		encontrado = false;
		
		for(Paciente pac : pacientes) {
			if(Ingreso.getPacienteId().equalsIgnoreCase(String.valueOf(pac.getPaciente_id()))) {
				encontrado = true;
			}
		}
		
		if(!encontrado) 
			throw new Exception("No se ha encontrado un paciente con el ID: " + Ingreso.getPacienteId());
		
		Paciente p = pacienteServiceI.obtenerPacientePorId(Long.valueOf(Ingreso.getPacienteId()));
		Medico m = medicoServiceI.obtenerMedicoPorId(Long.valueOf(Ingreso.getMedicoId()));					
		
		Ingreso i = new Ingreso();
		i.setHab(Ingreso.getHab());
		i.setCama(Ingreso.getCama());
		i.setFecing(fecing);
		i.setMedico(m);
		i.setPaciente(p);
		
		for(Ingreso ing : ingresos) {
			if(String.valueOf(i.getCama()).equalsIgnoreCase(String.valueOf(ing.getCama())) && 
					String.valueOf(i.getHab()).equalsIgnoreCase(String.valueOf(ing.getHab())) &&
					ing.getFecing().compareTo(i.getFecing())==0){
				throw new Exception("Ya hay un paciente con la misma cama y habitacion en una misma fecha");
			}
		}

		if (result.hasErrors()) {
			throw new Exception("Datos invalidos");
		} else {
			ingresoServiceI.aniadirIngreso(i);
		}

		return "redirect:showIngresoView";
	}
	
	@GetMapping("/showIngresosPacientes")
	public String mostrarIngresosPac(Model model) {
		// Obtención de ingresos
		final List<Paciente> listaIngresosPaciente = pacienteServiceI.obtenerTodosLosPacientes();

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresosPaciente);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresoPaciente";
	}
	
	@PostMapping("/showIngresosPacientesView")
	public String mostrarIngresosPacView(@Valid @ModelAttribute Paciente paciente, Model model) {

		final Paciente p = pacienteServiceI.obtenerPacientePorId(Long.valueOf(paciente.getPaciente_id()));

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.obtenerIngresosPorPaciente(p);

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngreso";
	}
	
	@GetMapping("/showIngresosMedicos")
	public String mostrarIngresosMed(Model model) {
		// Obtención de ingresos
		final List<Medico> listaIngresosMedico = medicoServiceI.obtenerTodosLosMedicos();

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresosMedico);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngresoMedico";
	}
	
	@PostMapping("/showIngresosMedicosView")
	public String mostrarIngresosMedView(@Valid @ModelAttribute Medico medico, Model model) {

		final Medico p = medicoServiceI.obtenerMedicoPorId(Long.valueOf(medico.getMedico_id()));

		// Obtención de pacientes
		final List<Ingreso> listaIngresos = ingresoServiceI.obtenerIngresosPorMedico(p);

		// Carga de datos al modelo
		model.addAttribute("IngresosListView", listaIngresos);
		model.addAttribute("btnDropMedicoEnabled", Boolean.FALSE);

		return "showIngreso";
	}
	
}

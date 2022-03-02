package com.clinicacordoba.myapp.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.servicios.IngresoServiceI;

@Controller
public class IngresoController {

	@Autowired
	private IngresoServiceI ingresoServiceI;
	
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

	
}

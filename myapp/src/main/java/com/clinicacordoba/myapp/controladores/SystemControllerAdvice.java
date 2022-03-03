package com.clinicacordoba.myapp.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase controladora de errores
 * @author Sergio
 *
 */
@ControllerAdvice
public class SystemControllerAdvice {
	
	/**
	 * Capta cualquier excepción en los métodos de cualquier controlador.
	 * @param req
	 * @param e Error recogido
	 * @param model
	 * @return Redirigue a la pagina de error
	 */

	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception e, Model model) {

		// Respuesta.
		model.addAttribute("errorMsg", e.getMessage());

		return "error";
	}

}


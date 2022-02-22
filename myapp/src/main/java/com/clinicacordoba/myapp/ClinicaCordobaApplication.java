package com.clinicacordoba.myapp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import com.clinicacordoba.myapp.entidades.Ingreso;
import com.clinicacordoba.myapp.entidades.Medico;
import com.clinicacordoba.myapp.entidades.Paciente;
import com.clinicacordoba.myapp.servicios.IngresoServiceI;

@SpringBootApplication
public class ClinicaCordobaApplication implements CommandLineRunner {

	/*@Autowired
	private IngresoServiceI ingresoServiceI;
	*/
	public static void main(String[] args) {
		SpringApplication.run(ClinicaCordobaApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		/*
		Medico m = new Medico();
		m.setName("Jose");
		m.setSurname("xD");
		m.setEspecialidad("Si");
		m.setPhone(Long.valueOf("32221"));
		m.setIngresos(null);
		Paciente p = new Paciente();
		p.setSurname("jeje");
		p.setName("jeje");
		p.setProvince("Cordoba");
		p.setIngresos(null);
		p.setAddress("Calle");
		p.setFecna(new Date());
		p.setPhone(Long.valueOf("32221"));
		p.setPc(Long.valueOf("32221"));
	

		System.out.println("------------");
	
			//Obtención e iteración de elementos.
		/*final List<Ingreso> IngresoList = ingresoServiceI.obtenerTodosLosIngresos();
			if (!CollectionUtils.isEmpty(IngresoList)) {
				for (Ingreso ingreso : IngresoList) {
					System.out.println(ingreso.toString());
				}
			}*/
		/*
		System.out.println("------------");
				
		// Obtención e iteración de elementos.
		final Ingreso i = ingresoServiceI.obtenerIngresoPorId(Long.valueOf("2"));
		//System.out.println(i.toString());
		
		
		System.out.println("------------");
		
		//Eliminar coche por Id
		//ingresoServiceI.eliminarIngresoPorId(i.getIngreso_id());
				
		//Añadir un coche
		Ingreso a = new Ingreso();
		
		ingresoServiceI.aniadirIngreso(i);
		*/
	}
	
}

package com.clinicacordoba.myapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicacordoba.myapp.entidades.Ingreso;

@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, Long>{

}

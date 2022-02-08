package com.clinicacordoba.myapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicacordoba.myapp.entidades.Medico;

@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long>{

}

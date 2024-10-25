package com.project.crm.repositories;

import com.project.crm.entities.Paciente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
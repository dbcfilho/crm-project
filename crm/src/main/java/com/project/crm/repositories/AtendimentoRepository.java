package com.project.crm.repositories;

import com.project.crm.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    Optional<Atendimento> findFirstByStatusOrderByIdAsc(String status);
}

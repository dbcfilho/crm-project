package com.example.crmproject.repository;

import com.example.crmproject.model.Senha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {
}

package com.project.crm.services;

import com.project.crm.entities.Atendimento;
import com.project.crm.entities.Paciente;
import com.project.crm.repositories.PacienteRepository;
import com.project.crm.repositories.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Gera uma senha no formato "A0001", "A0002", etc.
    public String gerarSenha() {
        Random random = new Random();
        int numero = random.nextInt(9999);
        return String.format("A%04d", numero);
    }

    // Emite uma nova senha e adiciona à fila de atendimento
    public Atendimento emitirSenha(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Atendimento atendimento = new Atendimento();
        atendimento.setSenha(gerarSenha());
        atendimento.setPaciente(paciente);
        atendimento.setStatus("AGUARDANDO");

        return atendimentoRepository.save(atendimento);
    }

    // Chama o próximo paciente da fila
    public Atendimento chamarProximo() {
        Atendimento atendimento = atendimentoRepository
                .findFirstByStatusOrderByIdAsc("AGUARDANDO")
                .orElseThrow(() -> new RuntimeException("Nenhum paciente na fila"));

        atendimento.setStatus("EM ATENDIMENTO");
        return atendimentoRepository.save(atendimento);
    }
}

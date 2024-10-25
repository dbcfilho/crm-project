package com.project.crm.controllers;

import com.project.crm.entities.Atendimento;
import com.project.crm.services.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    // Endpoint para emitir uma nova senha
    @PostMapping("/emitir/{pacienteId}")
    public Atendimento emitirSenha(@PathVariable Long pacienteId) {
        return atendimentoService.emitirSenha(pacienteId);
    }

    // Endpoint para chamar o próximo paciente
    @PostMapping("/chamarProximo")
    public Atendimento chamarProximo() {
        return atendimentoService.chamarProximo();
    }
}

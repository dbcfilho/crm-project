package com.example.crmproject.controller;

import com.example.crmproject.dto.SenhaRequest;
import com.example.crmproject.model.Senha;
import com.example.crmproject.repository.SenhaRepository;
import com.example.crmproject.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/senhas")
public class SenhaController {

    @Autowired
    private SenhaRepository senhaRepository;

    @GetMapping
    public List<Senha> getAllSenhas() {
        return senhaRepository.findAll();
    }

    @PostMapping
    public Senha createSenha(@RequestBody Senha senha) {
        return senhaRepository.save(senha);
    }

    @DeleteMapping("/{id}")
    public void deleteSenha(@PathVariable Long id) {
        if (senhaRepository.existsById(id)) {
            senhaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Senha com ID " + id + " não encontrada.");
        }
    }

    @Autowired
    private SenhaService senhaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarSenha(@RequestBody SenhaRequest senhaRequest) {
        Senha senha = new Senha();
        senha.setNumero(senhaRequest.getNumero());
        senha.setPaciente(senhaRequest.getPaciente());
        senha.setEspecialidade(senhaRequest.getEspecialidade());
        senha.setSala(Integer.parseInt(senhaRequest.getSala()));
        senha.setMedico(senhaRequest.getMedico());

        senhaService.salvarSenha(senha);
        return ResponseEntity.ok("Senha cadastrada com sucesso!");
    }
}

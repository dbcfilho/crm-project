package com.example.crmproject.service;

import com.example.crmproject.model.Senha;
import com.example.crmproject.repository.SenhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SenhaService {

    @Autowired
    private SenhaRepository senhaRepository;

    public List<Senha> listarTodas() {
        return senhaRepository.findAll();
    }

    public Optional<Senha> buscarPorId(Long id) {
        return senhaRepository.findById(id);
    }

    public Senha salvarSenha(Senha senha) {
        return senhaRepository.save(senha);
    }

    public void deletarSenha(Long id) {
        senhaRepository.deleteById(id);
    }

    public Senha chamarProximaSenha() {
        // Aqui você pode implementar a lógica para determinar a próxima senha a ser chamada
        List<Senha> senhas = senhaRepository.findAll();
        if (!senhas.isEmpty()) {
            Senha proximaSenha = senhas.get(0);  // Por exemplo, pegar a primeira senha
            // Remove a senha chamada (ou apenas a marca como chamada)
            senhaRepository.delete(proximaSenha);
            return proximaSenha;
        }
        return null;  // Retorna null se não houver mais senhas
    }
}

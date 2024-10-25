package com.example.crmproject.controller;

import com.example.crmproject.model.Senha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SenhaWebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @PostMapping("/send")
    public void sendSenha(@RequestBody Senha senha) {
        this.template.convertAndSend("/topic/senhas", senha);
    }
}

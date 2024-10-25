package com.project.crm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // Aqui ele vai buscar o arquivo 'index.html' na pasta 'static' ou 'templates'
    }
}

package com.carritocompra.proyectorudy1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaCatalogoController {

    @GetMapping("/")
    public String mostrarCatalogo() {
        return "catalogo"; // Thymeleaf buscará catalogo.html en /templates
    }
}

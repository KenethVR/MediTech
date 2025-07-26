package com.meditech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Add methods to handle requests here
    // For example, you can add a method to return the home page view

    @GetMapping({ "", "/", "/home", "/index" })
    public String home() {
        return "index"; // This should correspond to a view template named "index.html"
    }

    @GetMapping({ "/pacientes_index", "/pacientes" })
    public String pacientesIndex() {
        return "pacientesIndex"; // This should correspond to a view template named "index.html"
    }

    @GetMapping({ "/citas_index", "/citas" })
    public String citasIndex() {
        return "citasIndex"; // This should correspond to a view template named "index.html"
    }

    @GetMapping({ "/historial_index", "/historialIndex" })
    public String historialIndex() {
        return "historialIndex"; // This should correspond to a view template named "index.html"
    }

    @GetMapping({ "/traslados_index", "/trasladosIndex" })
    public String trasladosIndex() {
        return "trasladosIndex"; // This should correspond to a view template named "index.html"
    }

    @GetMapping({ "/medicos_index", "/medicosIndex" })
    public String medicosIndex() {
        return "medicosIndex"; // This should correspond to a view template named "index.html"
    }

    @GetMapping({ "/colaboradores_index", "/colaboradoresIndex" })
    public String colaboradoresIndex() {
        return "colaboradoresIndex"; // This should correspond to a view template named "index.html"
    }

}

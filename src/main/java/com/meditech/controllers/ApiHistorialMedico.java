package com.meditech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.meditech.models.HistorialMedico;
import com.meditech.services.historialService;

@RestController
@RequestMapping("/api/historial")
public class ApiHistorialMedico {

    @Autowired
    private historialService historialService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarAtencion(@RequestBody HistorialMedico historial) {
        boolean exito = historialService.registrarAtencion(historial);
        if (exito) {
            return ResponseEntity.ok("Atención registrada exitosamente");
        } else {
            return ResponseEntity.badRequest().body("No se pudo registrar la atención");
        }
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<HistorialMedico>> obtenerHistorialDePaciente(@PathVariable int id) {
        List<HistorialMedico> historial = historialService.obtenerHistorialDePaciente(id);
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<HistorialMedico>> obtenerTodos() {
        List<HistorialMedico> historiales = historialService.obtenerTodos();
        return ResponseEntity.ok(historiales);
    }
}

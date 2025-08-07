package com.meditech.controllers;

import com.meditech.models.Citas;
import com.meditech.services.citasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estructura/citas")
public class ApiCitas {

    @Autowired
    private citasService citasService;

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarCita(@RequestBody Citas cita) {
        citasService.agregarCita(cita);
        return ResponseEntity.ok("Cita agregada correctamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Citas>> listarCitas() {
        List<Citas> citas = citasService.listarCitas();
        return ResponseEntity.ok(citas);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificarCita(@RequestBody Citas cita) {
        boolean modificada = citasService.modificarCita(cita);
        if (modificada) {
            return ResponseEntity.ok("Cita modificada correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontró la cita para modificar");
        }
    }

    @GetMapping("/buscar/{cedula}")
    public ResponseEntity<List<Citas>> buscarPorCedula(@PathVariable int cedula) {
        List<Citas> citas = citasService.buscarCitasPorCedula(cedula);
        if (citas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<?> verificarDisponibilidad(@RequestParam String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            LocalDateTime fechaHora = LocalDateTime.parse(fecha, formatter);
            boolean disponible = citasService.estaDisponible(fechaHora);
            return ResponseEntity.ok().body(Map.of("disponible", disponible));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Formato de fecha inválido. Usa ISO_LOCAL_DATE_TIME (ej: 2025-08-06T10:00)"));
        }
    }
}

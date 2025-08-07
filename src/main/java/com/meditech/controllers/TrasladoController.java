package com.meditech.controllers;

import com.meditech.services.trasladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traslados")
public class TrasladoController {

    @Autowired
    private trasladoService trasladoService;

    @GetMapping("/ruta")
    public ResponseEntity<List<String>> obtenerRutaConNombres(@RequestParam int origen, @RequestParam int destino) {
        List<String> ruta = trasladoService.calcularRutaConNombres(origen, destino);
        if (ruta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ruta);
    }

    @GetMapping("/ruta/detallada")
    public ResponseEntity<List<String>> obtenerRutaDetallada(@RequestParam int origen, @RequestParam int destino) {
        List<String> rutaDetallada = trasladoService.calcularRutaDetallada(origen, destino);
        if (rutaDetallada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rutaDetallada);
    }
}

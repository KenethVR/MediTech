package com.meditech.controllers;

import com.meditech.models.Colaboradores;
import com.meditech.services.colaboradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estructura/colaboradores")
public class ApiColaboradores {

    @Autowired
    private colaboradoresService colaboradoresService;

    @GetMapping("/listar")
    public ResponseEntity<List<Colaboradores>> listar() {
        List<Colaboradores> lista = colaboradoresService.listarColaboradores();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregar(@RequestBody Colaboradores colaborador) {
        colaboradoresService.agregarColaborador(colaborador);
        return ResponseEntity.ok("Colaborador agregado correctamente");
    }

    @PutMapping("/modificar/{cedula}")
    public ResponseEntity<String> modificar(@PathVariable int cedula, @RequestBody Colaboradores colaborador) {
        boolean modificado = colaboradoresService.modificarColaborador(cedula, colaborador);
        if (modificado) {
            return ResponseEntity.ok("Colaborador modificado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{cedula}")
    public ResponseEntity<String> eliminar(@PathVariable int cedula) {
        boolean eliminado = colaboradoresService.eliminarColaborador(cedula);
        if (eliminado) {
            return ResponseEntity.ok("Colaborador eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/{cedula}")
    public ResponseEntity<Colaboradores> buscarColaborador(@PathVariable int cedula) {
        Colaboradores encontrado = colaboradoresService.buscarColaborador(cedula);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrado);
    }
}
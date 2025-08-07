package com.meditech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.meditech.models.Medicos;
import com.meditech.services.medicoService;

@RestController
@RequestMapping("/api/estructura/medicos")
public class ApiInfoMedicos {

    @Autowired
    private medicoService medicosService;

    @PostMapping("/agregar")
    public String agregarMedico(@RequestBody Medicos medico) {
        medicosService.agregarMedico(medico);
        return "Médico agregado al árbol";
    }

    @GetMapping("/listar")
    public List<Medicos> listarMedicos() {
        return medicosService.listarMedicos();
    }

    @GetMapping("/buscar/{cedula}")
    public ResponseEntity<Medicos> buscarMedico(@PathVariable int cedula) {
        Medicos medico = medicosService.buscarMedico(cedula);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{cedula}")
    public String eliminarMedico(@PathVariable int cedula) {
        medicosService.eliminarMedico(cedula);
        return "Médico eliminado del árbol";
    }

    @PutMapping("/modificar")
    public String modificarMedico(@RequestBody Medicos medico) {
        medicosService.modificarMedico(medico);
        return "Médico modificado en el árbol";
    }

    @GetMapping("/buscarPorServicio/{idServicio}")
    public List<Medicos> buscarPorServicio(@PathVariable int idServicio) {
        return medicosService.buscarPorServicio(idServicio);
    }

}
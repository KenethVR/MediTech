package com.meditech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditech.estructuras.PacienteEstructura;
import com.meditech.services.estructuraPacienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/estructura/pacientes")
@CrossOrigin
public class PacienteEstructuraController {

    @Autowired
    private estructuraPacienteService estructuraService;

    @PostMapping("/agregar")
    public String agregarPaciente(@RequestBody PacienteEstructura paciente) {
        estructuraService.agregarPaciente(paciente);
        return "Paciente agregado al árbol en memoria";
    }

    @RequestMapping("/listar")
    public Object listarPacientes() {
        return estructuraService.listarPacientes();
    }

    @PostMapping("/eliminar")
    public String eliminarPaciente(@RequestBody int cedula) {
        estructuraService.eliminarPaciente(cedula);
        return "Paciente eliminado del árbol en memoria";
    }

    @PutMapping("/modificar")
    public String modificarPaciente(@RequestBody PacienteEstructura paciente) {
        estructuraService.modificarPaciente(paciente);
        return "Paciente modificado en el árbol en memoria";
    }

    @GetMapping("/buscar/{cedula}")
    public PacienteEstructura buscarPaciente(@PathVariable int cedula) {
        PacienteEstructura paciente = estructuraService.buscarPaciente(cedula);
        if (paciente != null) {
            return paciente;
        } else {
            throw new RuntimeException("Paciente no encontrado");
        }
    }

    @GetMapping("/buscarNombre/{nombre}")
    public List<PacienteEstructura> buscarPacientePorNombre(@PathVariable String nombre) {
        return estructuraService.buscarPacientesPorNombre(nombre);
    }

}

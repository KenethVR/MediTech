package com.meditech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meditech.estructuras.ArbolPacienteUrgencia;
import com.meditech.estructuras.PacienteEstructura;

@Service
public class estructuraPacienteService {

    private ArbolPacienteUrgencia arbol = new ArbolPacienteUrgencia();

    public void agregarPaciente(PacienteEstructura paciente) {
        arbol.insertar(paciente);
    }

    public List<PacienteEstructura> listarPacientes() {
        return arbol.listarInOrden();
    }

    public void eliminarPaciente(int cedula) {
        arbol.eliminar(cedula);
    }

    public void limpiarArbol() {
        arbol = new ArbolPacienteUrgencia();
    }

    public ArbolPacienteUrgencia getArbol() {
        return arbol;
    }

    public void modificarPaciente(PacienteEstructura paciente) {
        arbol.modificarPaciente(paciente);
    }

    public PacienteEstructura buscarPaciente(int cedula) {
        return arbol.buscarPaciente(cedula);
    }

    public List<PacienteEstructura> buscarPacientesPorNombre(String nombre) {
        return arbol.buscarPacientesPorNombreParcial(nombre); // implementa la búsqueda parcial
    }
}

package com.meditech.estructuras;

import java.util.ArrayList;
import java.util.List;

public class ArbolPacienteUrgencia {

    private NodoPaciente raiz;

    public void insertar(PacienteEstructura paciente) {
        raiz = insertarRec(raiz, paciente);
    }

    private NodoPaciente insertarRec(NodoPaciente actual, PacienteEstructura paciente) {
        if (actual == null)
            return new NodoPaciente(paciente);

        int clave = paciente.getClaveBST();
        int claveActual = actual.paciente.getClaveBST();

        if (clave < claveActual) {
            actual.izquierdo = insertarRec(actual.izquierdo, paciente);
        } else if (clave > claveActual) {
            actual.derecho = insertarRec(actual.derecho, paciente);
        }
        return actual;
    }

    public List<PacienteEstructura> listarInOrden() {
        List<PacienteEstructura> lista = new ArrayList<>();
        inOrden(raiz, lista);
        return lista;
    }

    public void eliminar(int cedula) {
        raiz = eliminarRec(raiz, cedula);
    }

    private NodoPaciente eliminarRec(NodoPaciente actual, int cedula) {
        if (actual == null) {
            return null;
        }

        if (actual.paciente.getCedula() == cedula) {
            // Nodo encontrado
            if (actual.izquierdo == null) {
                return actual.derecho;
            } else if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // Nodo con dos hijos
            actual.paciente = encontrarMin(actual.derecho).paciente;
            actual.derecho = eliminarRec(actual.derecho, actual.paciente.getCedula());
            return actual;
        }

        actual.izquierdo = eliminarRec(actual.izquierdo, cedula);
        actual.derecho = eliminarRec(actual.derecho, cedula);
        return actual;
    }

    private NodoPaciente encontrarMin(NodoPaciente nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    private void inOrden(NodoPaciente nodo, List<PacienteEstructura> lista) {
        if (nodo != null) {
            inOrden(nodo.izquierdo, lista);
            lista.add(nodo.paciente);
            inOrden(nodo.derecho, lista);
        }
    }

    public void modificarPaciente(PacienteEstructura nuevoPaciente) {
        // Eliminar el paciente existente por cédula
        eliminar(nuevoPaciente.getCedula());

        // Insertar el nuevo objeto (posiblemente con una nueva clave BST)
        insertar(nuevoPaciente);
    }

    public PacienteEstructura buscarPaciente(int cedula) {
        return buscarRec(raiz, cedula);
    }

    public PacienteEstructura buscarPacientePorNombre(String nombre) {
        return buscarPorNombreRec(raiz, nombre);
    }

    private PacienteEstructura buscarPorNombreRec(NodoPaciente actual, String nombre) {
        if (actual == null) {
            return null;
        }

        if (actual.paciente.getNombre().equalsIgnoreCase(nombre)) {
            return actual.paciente;
        }

        // Buscar en subárbol izquierdo
        PacienteEstructura encontrado = buscarPorNombreRec(actual.izquierdo, nombre);
        if (encontrado != null) {
            return encontrado;
        }

        // Buscar en subárbol derecho
        return buscarPorNombreRec(actual.derecho, nombre);
    }

    private PacienteEstructura buscarRec(NodoPaciente actual, int cedula) {
        if (actual == null) {
            return null;
        }

        if (actual.paciente.getCedula() == cedula) {
            return actual.paciente;
        }

        PacienteEstructura encontrado = buscarRec(actual.izquierdo, cedula);
        if (encontrado == null) {
            encontrado = buscarRec(actual.derecho, cedula);
        }
        return encontrado;
    }

    public List<PacienteEstructura> buscarPacientesPorNombreParcial(String nombre) {
        List<PacienteEstructura> resultados = new ArrayList<>();
        buscarPorNombreParcialRec(raiz, nombre.toLowerCase(), resultados);
        return resultados;
    }

    private void buscarPorNombreParcialRec(NodoPaciente nodo, String nombre, List<PacienteEstructura> resultados) {
        if (nodo != null) {
            String nombreCompleto = (nodo.paciente.getNombre() + " " +
                    nodo.paciente.getApellido1() + " " +
                    nodo.paciente.getApellido2()).toLowerCase();
            if (nombreCompleto.contains(nombre)) {
                resultados.add(nodo.paciente);
            }
            buscarPorNombreParcialRec(nodo.izquierdo, nombre, resultados);
            buscarPorNombreParcialRec(nodo.derecho, nombre, resultados);
        }
    }

}

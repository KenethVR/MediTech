package com.meditech.estructuras;

import com.meditech.models.Medicos;
import java.util.ArrayList;
import java.util.List;

public class ArbolMedicos {

    private NodoMedico raiz;

    private static class NodoMedico {
        Medicos medico;
        NodoMedico izquierdo, derecho;

        NodoMedico(Medicos medico) {
            this.medico = medico;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    // Inserta un médico en el árbol
    public void insertar(Medicos medico) {
        raiz = insertarRec(raiz, medico);
    }

    private NodoMedico insertarRec(NodoMedico nodo, Medicos medico) {
        if (nodo == null) {
            return new NodoMedico(medico);
        }

        if (medico.getCedula() < nodo.medico.getCedula()) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, medico);
        } else if (medico.getCedula() > nodo.medico.getCedula()) {
            nodo.derecho = insertarRec(nodo.derecho, medico);
        } else {
            // Si la cédula ya existe, actualizamos el médico
            nodo.medico = medico;
        }
        return nodo;
    }

    // Busca un médico por cédula
    public Medicos buscar(int cedula) {
        return buscarRec(raiz, cedula);
    }

    private Medicos buscarRec(NodoMedico nodo, int cedula) {
        if (nodo == null) {
            return null;
        }

        if (cedula == nodo.medico.getCedula()) {
            return nodo.medico;
        } else if (cedula < nodo.medico.getCedula()) {
            return buscarRec(nodo.izquierdo, cedula);
        } else {
            return buscarRec(nodo.derecho, cedula);
        }
    }

    // Elimina un médico por cédula
    public void eliminar(int cedula) {
        raiz = eliminarRec(raiz, cedula);
    }

    private NodoMedico eliminarRec(NodoMedico nodo, int cedula) {
        if (nodo == null) {
            return null;
        }

        if (cedula < nodo.medico.getCedula()) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, cedula);
        } else if (cedula > nodo.medico.getCedula()) {
            nodo.derecho = eliminarRec(nodo.derecho, cedula);
        } else {
            // Nodo encontrado
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Nodo con dos hijos: encontrar sucesor
            NodoMedico sucesor = encontrarMinimo(nodo.derecho);
            nodo.medico = sucesor.medico;
            nodo.derecho = eliminarRec(nodo.derecho, sucesor.medico.getCedula());
        }
        return nodo;
    }

    private NodoMedico encontrarMinimo(NodoMedico nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    // Listar médicos en orden (cédula ascendente)
    public List<Medicos> listarInOrden() {
        List<Medicos> lista = new ArrayList<>();
        inOrdenRec(raiz, lista);
        return lista;
    }

    private void inOrdenRec(NodoMedico nodo, List<Medicos> lista) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo, lista);
            lista.add(nodo.medico);
            inOrdenRec(nodo.derecho, lista);
        }
    }

    // Buscar médicos por servicio
    public List<Medicos> buscarPorServicio(int idServicio) {
        List<Medicos> resultado = new ArrayList<>();
        buscarPorServicioRec(raiz, idServicio, resultado);
        return resultado;
    }

    private void buscarPorServicioRec(NodoMedico nodo, int idServicio, List<Medicos> resultado) {
        if (nodo != null) {
            buscarPorServicioRec(nodo.izquierdo, idServicio, resultado);
            Integer servicioId = nodo.medico.getServicioHospitalId();
            if (servicioId != null && servicioId.intValue() == idServicio) {
                resultado.add(nodo.medico);
            }
            buscarPorServicioRec(nodo.derecho, idServicio, resultado);
        }
    }

}

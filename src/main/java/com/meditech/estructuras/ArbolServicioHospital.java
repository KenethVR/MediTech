package com.meditech.estructuras;

import com.meditech.models.ServicioHospital;
import java.util.ArrayList;
import java.util.List;

public class ArbolServicioHospital {

    private Nodo raiz;

    private class Nodo {
        ServicioHospital dato;
        Nodo izquierda, derecha;

        Nodo(ServicioHospital dato) {
            this.dato = dato;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    public ArbolServicioHospital() {
        this.raiz = null;
        cargarDatosPorDefecto();
    }

    private void cargarDatosPorDefecto() {
        insertar(new ServicioHospital(0, "Ninguno", "N/A", true)); // Servicio por defecto
        insertar(new ServicioHospital(1, "Cardiología", "Segunda planta", true));
        insertar(new ServicioHospital(2, "Neurología", "Tercera planta", true));
        insertar(new ServicioHospital(3, "Pediatría", "Primera planta", true));
        insertar(new ServicioHospital(4, "Ginecología", "Cuarta planta", true));
        insertar(new ServicioHospital(5, "Radiología", "Quinta planta", true));
        insertar(new ServicioHospital(6, "Oncología", "Primera planta", true));
        insertar(new ServicioHospital(7, "Traumatología", "Segunda planta", true));
        // Agrega los que necesites con id y nombre
    }

    // Insertar un ServicioHospital en el árbol
    public void insertar(ServicioHospital servicio) {
        raiz = insertarRec(raiz, servicio);
    }

    private Nodo insertarRec(Nodo nodo, ServicioHospital servicio) {
        if (nodo == null) {
            return new Nodo(servicio);
        }
        if (servicio.getId() < nodo.dato.getId()) {
            nodo.izquierda = insertarRec(nodo.izquierda, servicio);
        } else if (servicio.getId() > nodo.dato.getId()) {
            nodo.derecha = insertarRec(nodo.derecha, servicio);
        } else {
            // Id duplicado, puedes decidir actualizar o ignorar
        }
        return nodo;
    }

    // Buscar por id
    public ServicioHospital buscar(int id) {
        Nodo nodo = buscarRec(raiz, id);
        return (nodo == null) ? null : nodo.dato;
    }

    private Nodo buscarRec(Nodo nodo, int id) {
        if (nodo == null || nodo.dato.getId() == id) {
            return nodo;
        }
        if (id < nodo.dato.getId()) {
            return buscarRec(nodo.izquierda, id);
        } else {
            return buscarRec(nodo.derecha, id);
        }
    }

    // Listar en orden ascendente por id
    public List<ServicioHospital> listarEnOrden() {
        List<ServicioHospital> lista = new ArrayList<>();
        listarEnOrdenRec(raiz, lista);
        return lista;
    }

    private void listarEnOrdenRec(Nodo nodo, List<ServicioHospital> lista) {
        if (nodo != null) {
            listarEnOrdenRec(nodo.izquierda, lista);
            lista.add(nodo.dato);
            listarEnOrdenRec(nodo.derecha, lista);
        }
    }

}
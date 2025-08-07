package com.meditech.estructuras;

import com.meditech.models.Colaboradores; // Asegúrate que esta ruta sea correcta
import java.util.ArrayList;
import java.util.List;

public class ArbolColaboradores {
    private class Nodo {
        Colaboradores colaborador;
        Nodo izquierdo, derecho;

        public Nodo(Colaboradores c) {
            this.colaborador = c;
            izquierdo = derecho = null;
        }
    }

    private Nodo raiz;

    public ArbolColaboradores() {
        raiz = null;
        cargarDatosPorDefecto();
    }

    // Insertar nuevo colaborador
    public void insertar(Colaboradores c) {
        raiz = insertarRec(raiz, c);
    }

    private void cargarDatosPorDefecto() {
        insertar(new Colaboradores(123456789, "Juan Pérez", 1, true));
        insertar(new Colaboradores(987654321, "Ana Gómez", 2, true));
        insertar(new Colaboradores(456789123, "Luis Martínez", 3, true));
        insertar(new Colaboradores(321654987, "María López", 4, true));
        // Agrega más colaboradores por defecto si es necesario
    }

    private Nodo insertarRec(Nodo raiz, Colaboradores c) {
        if (raiz == null) {
            raiz = new Nodo(c);
            return raiz;
        }
        if (c.getCedula() < raiz.colaborador.getCedula()) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, c);
        } else if (c.getCedula() > raiz.colaborador.getCedula()) {
            raiz.derecho = insertarRec(raiz.derecho, c);
        } else {
            // cédula ya existe, aquí podrías actualizar o ignorar
            // Por ahora no hacemos nada
        }
        return raiz;
    }

    // Buscar colaborador por cédula
    public Colaboradores buscar(int cedula) {
        return buscarRec(raiz, cedula);
    }

    private Colaboradores buscarRec(Nodo raiz, int cedula) {
        if (raiz == null) {
            return null;
        }
        if (cedula == raiz.colaborador.getCedula()) {
            return raiz.colaborador;
        }
        if (cedula < raiz.colaborador.getCedula()) {
            return buscarRec(raiz.izquierdo, cedula);
        }
        return buscarRec(raiz.derecho, cedula);
    }

    // Modificar colaborador por cedula
    public boolean modificar(int cedula, Colaboradores nuevoColaborador) {
        Nodo nodo = buscarNodo(raiz, cedula);
        if (nodo != null) {
            nodo.colaborador = nuevoColaborador;
            return true;
        }
        return false;
    }

    private Nodo buscarNodo(Nodo raiz, int cedula) {
        if (raiz == null) {
            return null;
        }
        if (cedula == raiz.colaborador.getCedula()) {
            return raiz;
        }
        if (cedula < raiz.colaborador.getCedula()) {
            return buscarNodo(raiz.izquierdo, cedula);
        }
        return buscarNodo(raiz.derecho, cedula);
    }

    // Eliminar colaborador por cedula
    public boolean eliminar(int cedula) {
        if (buscar(cedula) == null) {
            return false;
        }
        raiz = eliminarRec(raiz, cedula);
        return true;
    }

    private Nodo eliminarRec(Nodo raiz, int cedula) {
        if (raiz == null)
            return raiz;

        if (cedula < raiz.colaborador.getCedula()) {
            raiz.izquierdo = eliminarRec(raiz.izquierdo, cedula);
        } else if (cedula > raiz.colaborador.getCedula()) {
            raiz.derecho = eliminarRec(raiz.derecho, cedula);
        } else {
            // Nodo a eliminar encontrado

            // Caso 1 y 2: Nodo con un hijo o sin hijos
            if (raiz.izquierdo == null)
                return raiz.derecho;
            else if (raiz.derecho == null)
                return raiz.izquierdo;

            // Caso 3: Nodo con dos hijos
            Nodo sucesor = minValorNodo(raiz.derecho);
            raiz.colaborador = sucesor.colaborador;
            raiz.derecho = eliminarRec(raiz.derecho, sucesor.colaborador.getCedula());
        }
        return raiz;
    }

    private Nodo minValorNodo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    // Listar colaboradores en orden ascendente por cédula
    public List<Colaboradores> listarEnOrden() {
        List<Colaboradores> lista = new ArrayList<>();
        listarEnOrdenRec(raiz, lista);
        return lista;
    }

    private void listarEnOrdenRec(Nodo nodo, List<Colaboradores> lista) {
        if (nodo != null) {
            listarEnOrdenRec(nodo.izquierdo, lista);
            lista.add(nodo.colaborador);
            listarEnOrdenRec(nodo.derecho, lista);
        }
    }
}
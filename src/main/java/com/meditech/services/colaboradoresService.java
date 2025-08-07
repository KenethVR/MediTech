package com.meditech.services;

import com.meditech.estructuras.ArbolColaboradores;
import com.meditech.models.Colaboradores;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class colaboradoresService {

    private ArbolColaboradores arbol;

    public colaboradoresService() {
        this.arbol = new ArbolColaboradores();
        // Si quieres, aquí puedes inicializar con algunos colaboradores por defecto.
    }

    public void agregarColaborador(Colaboradores c) {
        arbol.insertar(c);
    }

    public List<Colaboradores> listarColaboradores() {
        return arbol.listarEnOrden();
    }

    public Colaboradores buscarColaborador(int cedula) {
        return arbol.buscar(cedula);
    }

    public boolean modificarColaborador(int cedula, Colaboradores cNuevo) {
        return arbol.modificar(cedula, cNuevo);
    }

    public boolean eliminarColaborador(int cedula) {
        return arbol.eliminar(cedula);
    }
}
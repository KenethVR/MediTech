package com.meditech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meditech.models.Medicos;
import com.meditech.estructuras.ArbolMedicos;

@Service
public class medicoService {

    private ArbolMedicos arbolMedicos = new ArbolMedicos();

    public void agregarMedico(Medicos medico) {
        arbolMedicos.insertar(medico);
    }

    public List<Medicos> listarMedicos() {
        return arbolMedicos.listarInOrden();
    }

    public Medicos buscarMedico(int cedula) {
        return arbolMedicos.buscar(cedula);
    }

    public void eliminarMedico(int cedula) {
        arbolMedicos.eliminar(cedula);
    }

    public void modificarMedico(Medicos medico) {
        arbolMedicos.eliminar(medico.getCedula());
        arbolMedicos.insertar(medico);
    }

    public List<Medicos> buscarPorServicio(int idServicio) {
        return arbolMedicos.buscarPorServicio(idServicio);
    }

}
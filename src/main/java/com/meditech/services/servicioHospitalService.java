package com.meditech.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meditech.estructuras.ArbolServicioHospital;
import com.meditech.models.ServicioHospital;

@Service
public class servicioHospitalService {

    private ArbolServicioHospital arbolServicios;

    public servicioHospitalService() {
        this.arbolServicios = new ArbolServicioHospital(); // Carga datos por defecto en constructor
    }

    public List<ServicioHospital> listarServicios() {
        return arbolServicios.listarEnOrden();
    }

    // Puedes agregar más métodos para agregar, modificar o eliminar servicios si lo
    // necesitas
}
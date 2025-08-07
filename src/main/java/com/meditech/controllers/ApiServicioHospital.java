package com.meditech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditech.models.ServicioHospital;
import com.meditech.services.servicioHospitalService;

@RestController
public class ApiServicioHospital {

    @Autowired
    private servicioHospitalService servicioHospitalService;

    // Endpoint para obtener todos los servicios hospitalarios
    @GetMapping("/api/cargar/servicios")
    public ResponseEntity<List<ServicioHospital>> listarServicios() {
        List<ServicioHospital> lista = servicioHospitalService.listarServicios();
        return ResponseEntity.ok(lista);
    }

}
package com.meditech.services;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.meditech.estructuras.GrafoHospital;

import jakarta.annotation.PostConstruct;

@Service
public class trasladoService {

    private GrafoHospital grafo;
    private Map<Integer, String> servicioNombres;

    @PostConstruct
    public void inicializar() {
        grafo = new GrafoHospital();
        servicioNombres = new HashMap<>();
        // Cargar servicios por defecto
        servicioNombres.put(0, "Ninguno"); // Servicio por defecto
        servicioNombres.put(1, "Cardiología");
        servicioNombres.put(2, "Neurología");
        servicioNombres.put(3, "Pediatría");
        servicioNombres.put(4, "Ginecología");
        servicioNombres.put(5, "Radiología");
        servicioNombres.put(6, "Oncología");
        servicioNombres.put(7, "Traumatología");
        // Agrega conexiones entre servicios con pesos y descripciones de pasillos
        grafo.agregarConexion(0, 1, 5, "Pasillo A – Entrada entre Ninguno y Cardiología");
        grafo.agregarConexion(0, 2, 3, "Pasillo B – Entrada entre Ninguno y Neurología");
        grafo.agregarConexion(0, 3, 4, "Pasillo C – Entrada entre Ninguno y Pediatría");
        grafo.agregarConexion(0, 4, 6, "Pasillo D – Entrada entre Ninguno y Ginecología");
        grafo.agregarConexion(0, 5, 7, "Pasillo E – Entrada entre Ninguno y Radiología");
        grafo.agregarConexion(0, 6, 8, "Pasillo F – Entrada entre Ninguno y Oncología");
        grafo.agregarConexion(0, 7, 2, "Pasillo G – Entrada entre Ninguno y Traumatología");

        grafo.agregarConexion(1, 2, 4, "Pasillo H – Conexión entre Cardiología y Neurología");
        grafo.agregarConexion(1, 3, 5, "Pasillo I – Conexión entre Cardiología y Pediatría");
        grafo.agregarConexion(1, 4, 6, "Pasillo J – Conexión entre Cardiología y Ginecología");
        grafo.agregarConexion(1, 5, 7, "Pasillo K – Conexión entre Cardiología y Radiología");
        grafo.agregarConexion(1, 6, 5, "Pasillo L – Conexión entre Cardiología y Oncología");
        grafo.agregarConexion(1, 7, 3, "Pasillo M – Conexión entre Cardiología y Traumatología");

        grafo.agregarConexion(2, 3, 2, "Pasillo N – Conexión entre Neurología y Pediatría");
        grafo.agregarConexion(2, 4, 4, "Pasillo O – Conexión entre Neurología y Ginecología");
        grafo.agregarConexion(2, 5, 6, "Pasillo P – Conexión entre Neurología y Radiología");
        grafo.agregarConexion(2, 6, 5, "Pasillo Q – Conexión entre Neurología y Oncología");
        grafo.agregarConexion(2, 7, 3, "Pasillo R – Conexión entre Neurología y Traumatología");

        grafo.agregarConexion(3, 4, 3, "Pasillo S – Conexión entre Pediatría y Ginecología");
        grafo.agregarConexion(3, 5, 4, "Pasillo T – Conexión entre Pediatría y Radiología");
        grafo.agregarConexion(3, 6, 2, "Pasillo U – Conexión entre Pediatría y Oncología");
        grafo.agregarConexion(3, 7, 4, "Pasillo V – Conexión entre Pediatría y Traumatología");

        grafo.agregarConexion(4, 5, 6, "Pasillo W – Conexión entre Ginecología y Radiología");
        grafo.agregarConexion(4, 6, 4, "Pasillo X – Conexión entre Ginecología y Oncología");
        grafo.agregarConexion(4, 7, 3, "Pasillo Y – Conexión entre Ginecología y Traumatología");

        grafo.agregarConexion(5, 6, 3, "Pasillo Z – Conexión entre Radiología y Oncología");
        grafo.agregarConexion(5, 7, 4, "Pasillo AA – Conexión entre Radiología y Traumatología");

        grafo.agregarConexion(6, 7, 2, "Pasillo AB – Conexión entre Oncología y Traumatología");
    }

    public List<Integer> calcularRuta(int origen, int destino) {
        return grafo.caminoMasCorto(origen, destino);
    }

    public List<String> calcularRutaConNombres(int origen, int destino) {
        List<Integer> rutaIds = grafo.caminoMasCorto(origen, destino);
        return rutaIds.stream()
                .map(id -> servicioNombres.getOrDefault(id, "Desconocido"))
                .toList();
    }

    public List<String> calcularRutaDetallada(int origen, int destino) {
        return grafo.describirRutaDetallada(origen, destino, servicioNombres);
    }
}

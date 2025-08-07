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
        grafo.agregarConexion(0, 1, 5, "Pasillo A – Entrada principal a Cardiología"); // Ninguno -> Cardiología
        grafo.agregarConexion(0, 2, 3, "Pasillo B – Entrada principal a Neurología"); // Ninguno -> Neurología
        grafo.agregarConexion(0, 3, 4, "Pasillo C – Entrada principal a Pediatría"); // Ninguno -> Pediatría
        grafo.agregarConexion(0, 4, 6, "Pasillo D – Entrada principal a Ginecología"); // Ninguno -> Ginecología
        grafo.agregarConexion(0, 5, 7, "Pasillo E – Entrada principal a Radiología"); // Ninguno -> Radiología
        grafo.agregarConexion(0, 6, 8, "Pasillo F – Entrada principal a Oncología"); // Ninguno -> Oncología
        grafo.agregarConexion(0, 7, 2, "Pasillo G – Entrada principal a Traumatología"); // Ninguno -> Traumatología
        grafo.agregarConexion(1, 3, 5, "Pasillo A – Cardiología a Pediatría"); // Cardiología -> Pediatría
        grafo.agregarConexion(1, 7, 2, "Pasillo B – Zona de Diagnóstico"); // Cardiología -> Traumatología
        grafo.agregarConexion(1, 2, 4, "Pasillo A – Conexión principal"); // Cardiología -> Neurología
        grafo.agregarConexion(2, 4, 3, "Ascensor este – Piso 3 a 4"); // Neurología -> Ginecología
        grafo.agregarConexion(3, 1, 5, "Pasillo C – Infantil a Cardiología"); // Pediatría -> Cardiología
        grafo.agregarConexion(3, 6, 2, "Pasillo D – Área infantil"); // Pediatría -> Oncología
        grafo.agregarConexion(4, 5, 6, "Pasillo E – Diagnóstico por imagen"); // Ginecología -> Radiología
        grafo.agregarConexion(6, 5, 3, "Pasillo F – Tratamientos avanzados"); // Oncología -> Radiología
        grafo.agregarConexion(7, 3, 4, "Pasillo G – Urgencias a Pediatría"); // Traumatología -> Pediatría
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

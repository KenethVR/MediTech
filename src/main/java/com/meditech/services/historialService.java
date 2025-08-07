package com.meditech.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.meditech.models.HistorialMedico;

@Service
public class historialService {

    private TreeMap<Integer, List<HistorialMedico>> historialPorPaciente = new TreeMap<>();
    private int idActual = 1;

    public boolean registrarAtencion(HistorialMedico atencion) {
        atencion.setId(idActual++);
        atencion.setFechaCreacion(LocalDateTime.now());

        historialPorPaciente.computeIfAbsent(atencion.getPaciente(), k -> new ArrayList<>()).add(atencion);
        return true;
    }

    public List<HistorialMedico> obtenerHistorialDePaciente(int pacienteId) {
        return historialPorPaciente.getOrDefault(pacienteId, new ArrayList<>());
    }

    public List<HistorialMedico> obtenerTodos() {
        return historialPorPaciente.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}

package com.meditech.services;

import com.meditech.models.Citas;
import com.meditech.estructuras.ColaPrioridadCitas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class citasService {

    private final ColaPrioridadCitas colaPrioridadCitas;

    public citasService() {
        this.colaPrioridadCitas = new ColaPrioridadCitas();
    }

    private int contadorId = 1;

    public void agregarCita(Citas cita) {
        cita.setId(contadorId++);
        colaPrioridadCitas.agregar(cita);
    }

    public List<Citas> listarCitas() {
        return colaPrioridadCitas.listarOrdenadas();
    }

    public List<Citas> buscarCitasPorCedula(int cedula) {
        return colaPrioridadCitas.buscarPorCedula(cedula);
    }

    public boolean modificarCita(Citas citaModificada) {
        return colaPrioridadCitas.modificar(citaModificada.getId(), citaModificada);
    }

    public boolean estaDisponible(LocalDateTime fechaHora) {
        return colaPrioridadCitas.estaDisponible(fechaHora);
    }
}

package com.meditech.estructuras;

import com.meditech.models.Citas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ColaPrioridadCitas {

    private PriorityQueue<Citas> cola;

    public ColaPrioridadCitas() {
        // La menor urgenciaClinica tiene mayor prioridad (1 = URGENTE, etc.)
        this.cola = new PriorityQueue<>(Comparator.comparingInt(
                c -> c.getUrgenciaClinica().getPrioridad()));
    }

    public void agregar(Citas cita) {
        cola.add(cita);
    }

    public List<Citas> listarOrdenadas() {
        return new ArrayList<>(cola);
    }

    public List<Citas> buscarPorCedula(int cedula) {
        List<Citas> resultados = new ArrayList<>();
        for (Citas c : cola) {
            if (c.getPaciente() == cedula) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public boolean modificar(int idCita, Citas citaNueva) {
        List<Citas> temp = new ArrayList<>();
        boolean encontrada = false;

        while (!cola.isEmpty()) {
            Citas actual = cola.poll();
            if (actual.getId() == idCita) {
                encontrada = true;
                // Reemplazar los datos preservando la prioridad
                temp.add(citaNueva);
            } else {
                temp.add(actual);
            }
        }

        cola.addAll(temp);
        return encontrada;
    }

    public boolean estaDisponible(LocalDateTime fechaHora) {
        for (Citas cita : cola) {
            if (cita.getFechaCita() != null && cita.getFechaCita().equals(fechaHora)) {
                return false; // Ya existe una cita para esa fecha y hora
            }
        }
        return true;
    }
}

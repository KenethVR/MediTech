package com.meditech.estructuras;

public enum UrgenciaClinica {
    URGENTE(1),
    CRITICO(2),
    GRAVE(3),
    OBSERVACION(4),
    ESTABLE(5);

    private final int prioridad;

    UrgenciaClinica(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
}

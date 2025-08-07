package com.meditech.estructuras;

public class NodoPaciente {
    PacienteEstructura paciente;
    NodoPaciente izquierdo;
    NodoPaciente derecho;

    public NodoPaciente(PacienteEstructura paciente) {
        this.paciente = paciente;
        this.izquierdo = null;
        this.derecho = null;
    }
}

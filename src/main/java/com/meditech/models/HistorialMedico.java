package com.meditech.models;

import java.time.LocalDateTime;

import com.meditech.models.Medicos;
import com.meditech.models.ServicioHospital;

// La clase HistorialMedico representa el historial médico de un paciente en el
// sistema MediTech
public class HistorialMedico {

    public HistorialMedico() {
        // Constructor por defecto necesario para JPA
        // Este constructor es requerido por JPA para crear instancias de la entidad
        // sin necesidad de pasar parámetros.
        // No es necesario inicializar los campos aquí, ya que JPA los manejará.
    }

    public HistorialMedico(int id, int paciente, int medico, int servicioHospital, String diagnostico,
            String tratamiento,
            String notas) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.servicioHospital = servicioHospital;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.notas = notas;
        this.fechaCreacion = LocalDateTime.now(); // Establece la fecha de creación
    }

    private int id;

    private int paciente;

    private int medico;

    private int servicioHospital;

    private String diagnostico;

    private String tratamiento;

    private String notas;

    private LocalDateTime fechaCreacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getMedico() {
        return medico;
    }

    public void setMedico(int medico) {
        this.medico = medico;
    }

    public int getServicioHospital() {
        return servicioHospital;
    }

    public void setServicioHospital(int servicioHospital) {
        this.servicioHospital = servicioHospital;
    }

    @Override
    public String toString() {
        return "HistorialMedico [id=" + id + ", paciente=" + paciente + ", medico=" + medico + ", servicioHospital="
                + servicioHospital + "]";
    }

}

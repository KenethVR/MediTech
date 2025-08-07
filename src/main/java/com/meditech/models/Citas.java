package com.meditech.models;

import java.time.LocalDateTime;

import com.meditech.estructuras.UrgenciaClinica;

public class Citas {

    public Citas() {
        // Constructor por defecto necesario para JPA
        // Este constructor es requerido por JPA para crear instancias de la entidad
        // sin necesidad de pasar parámetros.
        // No es necesario inicializar los campos aquí, ya que JPA los manejará.
        // Si se desea, se pueden inicializar con valores por defecto.
    }

    public Citas(int id, String motivoConsulta, String dictamenMedico, boolean estado, LocalDateTime fechaCita,
            int paciente, int medico, int areaServicio, UrgenciaClinica urgenciaClinica) {
        this.id = id;
        this.motivoConsulta = motivoConsulta;
        this.dictamenMedico = dictamenMedico;
        this.estado = estado;
        this.fechaCita = fechaCita;
        this.paciente = paciente;
        this.medico = medico;
        this.areaServicio = areaServicio;
        this.urgenciaClinica = urgenciaClinica;
    }

    private int id;

    private String motivoConsulta;

    private String dictamenMedico;

    private boolean estado;

    private LocalDateTime fechaCita;

    private UrgenciaClinica urgenciaClinica;

    private int paciente;

    private int medico;

    private int areaServicio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getDictamenMedico() {
        return dictamenMedico;
    }

    public void setDictamenMedico(String dictamenMedico) {
        this.dictamenMedico = dictamenMedico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
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

    public int getAreaServicio() {
        return areaServicio;
    }

    public void setAreaServicio(int areaServicio) {
        this.areaServicio = areaServicio;
    }

    public UrgenciaClinica getUrgenciaClinica() {
        return urgenciaClinica;
    }

    public void setUrgenciaClinica(UrgenciaClinica urgenciaClinica) {
        this.urgenciaClinica = urgenciaClinica;
    }

    @Override
    public String toString() {
        return "Citas{" +
                "id=" + id +
                ", motivoConsulta='" + motivoConsulta + '\'' +
                ", dictamenMedico='" + dictamenMedico + '\'' +
                ", estado=" + estado +
                ", fechaCita=" + fechaCita +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", areaHospital=" + areaServicio +
                ", urgenciaClinica=" + urgenciaClinica +
                '}';
    }

}

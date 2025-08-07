package com.meditech.models;

import java.sql.Date;

public class Medicos {

    public Medicos(int cedula, String nombre, String apellidos, String genero, Date fechaNacimiento,
            String especialidad, int servicioHospitalId) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
        this.servicioHospitalId = servicioHospitalId;
    }

    // La cédula es el identificador único del médico.
    private int cedula;

    private String nombre;

    private String apellidos;

    private String genero;

    private Date fechaNacimiento;

    private String especialidad;

    private int servicioHospitalId;

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getServicioHospitalId() {
        return servicioHospitalId;
    }

    public void setServicioHospitalId(int servicioHospitalId) {
        this.servicioHospitalId = servicioHospitalId;
    }

    @Override
    public String toString() {
        return "Medicos{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", especialidad='" + especialidad + '\'' +
                ", servicioHospitalId=" + servicioHospitalId +
                '}';
    }

}
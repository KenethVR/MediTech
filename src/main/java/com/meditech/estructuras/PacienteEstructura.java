package com.meditech.estructuras;

import java.util.Date;

public class PacienteEstructura {

    private int cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private String genero;
    private String telefono;
    private String direccion;
    private String contactoEmergencia;
    private String telefonoEmergencia;
    private UrgenciaClinica urgenciaClinica; // Representa el estado clínico del paciente
    private boolean estado; // Indica si el paciente está activo o inactivo
    private int servicioHospitalId;

    public PacienteEstructura(int cedula, String nombre, String apellido1, String apellido2, Date fechaNacimiento,
            String genero, String telefono, String direccion, String contactoEmergencia, String telefonoEmergencia,
            UrgenciaClinica urgenciaClinica, boolean estado, int servicioHospitalId) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contactoEmergencia = contactoEmergencia;
        this.telefonoEmergencia = telefonoEmergencia;
        this.urgenciaClinica = urgenciaClinica;
        this.estado = estado;
        this.servicioHospitalId = servicioHospitalId; // Asignación del ID del servicio hospitalario
    }

    // Getters y Setters
    public int getCedula() {
        return cedula;
    }

    public int getClaveBST() {
        return urgenciaClinica.getPrioridad() * 1000000000 + cedula;
    }

    public void setServicioHospitalId(int servicioHospitalId) {
        this.servicioHospitalId = servicioHospitalId;
    }

    public int getServicioHospitalId() {
        return servicioHospitalId;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public UrgenciaClinica getUrgenciaClinica() {
        return urgenciaClinica;
    }

    public void setUrgenciaClinica(UrgenciaClinica urgenciaClinica) {
        this.urgenciaClinica = urgenciaClinica;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PacienteEstructura{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero='" + genero + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", contactoEmergencia='" + contactoEmergencia + '\'' +
                ", telefonoEmergencia='" + telefonoEmergencia + '\'' +
                ", urgenciaClinica=" + urgenciaClinica +
                ", estado=" + estado +
                ", servicioHospitalId=" + servicioHospitalId +
                '}';
    }

}

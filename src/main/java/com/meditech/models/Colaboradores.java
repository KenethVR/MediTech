package com.meditech.models;

// La clase Colaboradores representa a los colaboradores en el sistema MediTech.
public class Colaboradores {

    private int cedula;

    private String nombre;

    private int areaServicio;

    private boolean estado;

    public Colaboradores(int cedula, String nombre, int areaServicio, boolean estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.areaServicio = areaServicio;
        this.estado = estado;
    }

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

    public int getAreaServicio() {
        return areaServicio;
    }

    public void setAreaServicio(int areaServicio) {
        this.areaServicio = areaServicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Colaboradores{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", areaServicio=" + areaServicio +
                ", estado=" + estado;
    }

}

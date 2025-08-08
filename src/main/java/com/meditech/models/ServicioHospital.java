package com.meditech.models;

public class ServicioHospital {

    public ServicioHospital(int id, String descripcion, String ubicacion, boolean activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }

    private int id;

    private String descripcion;

    private String ubicacion;

    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ServicioHospital{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", activo=" + activo +
                '}';
    }

}

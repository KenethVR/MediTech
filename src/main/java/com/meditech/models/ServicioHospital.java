package com.meditech.models;

public class ServicioHospital {

    public ServicioHospital() {
        // Constructor por defecto necesario para JPA
        // Este constructor es requerido por JPA para crear instancias de la entidad
        // sin necesidad de pasar parámetros.
        // No es necesario inicializar los campos aquí, ya que JPA los manejará.
        // Si se desea, se pueden inicializar con valores por defecto.
    }

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

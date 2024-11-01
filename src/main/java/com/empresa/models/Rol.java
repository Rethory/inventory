package com.empresa.models;

public class Rol {
    private int idRol;
    private String rol;

    // Constructor
    public Rol(int idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    // Getters y Setters
    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}

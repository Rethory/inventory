package com.empresa.models;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int cantidad;
    private int estatus;

    // Constructor
    public Producto(int idProducto, String nombreProducto, int cantidad, int estatus) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.estatus = estatus;
    }

    // Getters y Setters
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public int getEstatus() { return estatus; }
    public void setEstatus(int estatus) { this.estatus = estatus; }
}

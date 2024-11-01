package com.empresa.models;

import java.sql.Timestamp;

public class Movimiento {
    private int idMovimiento;
    private int idProducto;
    private int idUsuario;
    private int idTipoMovimiento;
    private int cantidad;
    private Timestamp fecha;

    // Constructor
    public Movimiento(int idMovimiento, int idProducto, int idUsuario, int idTipoMovimiento, int cantidad, Timestamp fecha) {
        this.idMovimiento = idMovimiento;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.idTipoMovimiento = idTipoMovimiento;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdMovimiento() { return idMovimiento; }
    public void setIdMovimiento(int idMovimiento) { this.idMovimiento = idMovimiento; }
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public int getIdTipoMovimiento() { return idTipoMovimiento; }
    public void setIdTipoMovimiento(int idTipoMovimiento) { this.idTipoMovimiento = idTipoMovimiento; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }
}

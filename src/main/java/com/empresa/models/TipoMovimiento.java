package com.empresa.models;

public class TipoMovimiento {
    private int idTipoMovimiento;
    private String tipo;

    // Constructor
    public TipoMovimiento(int idTipoMovimiento, String tipo) {
        this.idTipoMovimiento = idTipoMovimiento;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getIdTipoMovimiento() { return idTipoMovimiento; }
    public void setIdTipoMovimiento(int idTipoMovimiento) { this.idTipoMovimiento = idTipoMovimiento; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}

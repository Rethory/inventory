package com.empresa.controllers;

import com.empresa.models.Movimiento;
import com.empresa.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimientoController {
    public List<Movimiento> listarMovimientos(int tipoMovimiento) throws SQLException {
        List<Movimiento> movimientos = new ArrayList<>();
        String query = "SELECT * FROM movimientos WHERE idTipoMovimiento = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, tipoMovimiento);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                movimientos.add(new Movimiento(
                        rs.getInt("idMovimiento"),
                        rs.getInt("idProducto"),
                        rs.getInt("idUsuario"),
                        rs.getInt("idTipoMovimiento"),
                        rs.getInt("cantidad"),
                        rs.getTimestamp("fecha")
                ));
            }
        }
        return movimientos;
    }

    public boolean registrarEntrada(int idProducto, int idUsuario, int cantidad) throws SQLException {
        String query = "INSERT INTO movimientos (idProducto, idUsuario, idTipoMovimiento, cantidad, fecha) VALUES (?, ?, 1, ?, NOW())";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idProducto);
            stmt.setInt(2, idUsuario);
            stmt.setInt(3, cantidad);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean registrarSalida(int idProducto, int idUsuario, int cantidad) throws SQLException {
        String queryCheckStock = "SELECT cantidad FROM productos WHERE idProducto = ?";
        String queryInsert = "INSERT INTO movimientos (idProducto, idUsuario, idTipoMovimiento, cantidad, fecha) VALUES (?, ?, 2, ?, NOW())";

        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmtCheckStock = conn.prepareStatement(queryCheckStock);
            stmtCheckStock.setInt(1, idProducto);
            ResultSet rs = stmtCheckStock.executeQuery();

            if (rs.next() && rs.getInt("cantidad") >= cantidad) {
                PreparedStatement stmtInsert = conn.prepareStatement(queryInsert);
                stmtInsert.setInt(1, idProducto);
                stmtInsert.setInt(2, idUsuario);
                stmtInsert.setInt(3, cantidad);
                return stmtInsert.executeUpdate() > 0;
            } else {
                System.out.println("Error: cantidad insuficiente.");
                return false;
            }
        }
    }
}

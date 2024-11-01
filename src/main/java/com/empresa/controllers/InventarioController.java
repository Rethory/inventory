package com.empresa.controllers;

import com.empresa.models.Producto;
import com.empresa.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioController {
    public List<Producto> listarProductos(boolean activos) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM productos WHERE estatus = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, activos ? 1 : 0);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombreProducto"),
                        rs.getInt("cantidad"),
                        rs.getInt("estatus")
                ));
            }
        }
        return productos;
    }

    public boolean agregarProducto(String nombreProducto) throws SQLException {
        String query = "INSERT INTO productos (nombreProducto, cantidad, estatus) VALUES (?, 0, 1)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombreProducto);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean darDeBajaProducto(int idProducto) throws SQLException {
        String query = "UPDATE productos SET estatus = 0 WHERE idProducto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idProducto);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean reactivarProducto(int idProducto) throws SQLException {
        String query = "UPDATE productos SET estatus = 1 WHERE idProducto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idProducto);
            return stmt.executeUpdate() > 0;
        }
    }
}

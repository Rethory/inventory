package com.empresa.controllers;

import com.empresa.models.Usuario;
import com.empresa.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthController {
    public Usuario login(String correo, String contraseña) throws SQLException {
        Usuario usuario = null;

        String query = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ? AND estatus = 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, correo);
            stmt.setString(2, contraseña);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getInt("idRol"),
                        rs.getInt("estatus")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return usuario;
    }
}

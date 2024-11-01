package com.empresa.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream(".env")) {
                Properties prop = new Properties();
                if (input == null) {
                    System.out.println("No se encontró el archivo de configuración.");
                    return null;
                }
                prop.load(input);

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.user");
                String password = prop.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

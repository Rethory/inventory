package com.empresa.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void testConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Conexión a la base de datos exitosa!");
        } catch (Exception e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
}

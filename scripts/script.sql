-- Crear base de datos
CREATE DATABASE inventario_db;

-- Usar la base de datos creada
USE inventario_db;

-- Crear tabla de Roles
CREATE TABLE Roles (
    idRol INT PRIMARY KEY AUTO_INCREMENT,
    rol VARCHAR(50) NOT NULL
);

-- Crear tabla de Usuarios
CREATE TABLE Usuarios (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(50) NOT NULL UNIQUE,
    contraseña VARCHAR(25) NOT NULL,
    idRol INT,
    estatus INT(1) DEFAULT 1,
    FOREIGN KEY (idRol) REFERENCES Roles(idRol)
);

-- Crear tabla de Productos
CREATE TABLE Productos (
    idProducto INT PRIMARY KEY AUTO_INCREMENT,
    nombreProducto VARCHAR(100) NOT NULL,
    cantidad INT DEFAULT 0,
    estatus INT(1) DEFAULT 1
);

-- Crear tabla de Tipos de Movimiento
CREATE TABLE TiposMovimiento (
    idTipoMovimiento INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL
);

-- Crear tabla de Movimientos
CREATE TABLE Movimientos (
    idMovimiento INT PRIMARY KEY AUTO_INCREMENT,
    idProducto INT,
    idUsuario INT,
    idTipoMovimiento INT,
    cantidad INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idProducto) REFERENCES Productos(idProducto),
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario),
    FOREIGN KEY (idTipoMovimiento) REFERENCES TiposMovimiento(idTipoMovimiento)
);

-- Insertar roles predefinidos
INSERT INTO Roles (rol) VALUES ('Administrador'), ('Almacenista');

-- Insertar tipos de movimiento predefinidos
INSERT INTO TiposMovimiento (tipo) VALUES ('Entrada'), ('Salida');

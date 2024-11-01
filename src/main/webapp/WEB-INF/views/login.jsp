<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio de Sesión</title>
</head>
<body>
<h2>Iniciar Sesión</h2>
<form action="auth/login" method="post">
    <label for="correo">Correo:</label>
    <input type="email" id="correo" name="correo" required>

    <label for="contraseña">Contraseña:</label>
    <input type="password" id="contraseña" name="contraseña" required>

    <button type="submit">Iniciar Sesión</button>
</form>
</body>
</html>

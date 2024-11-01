<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inventario</title>
</head>
<body>
<h2>Inventario de Productos</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Cantidad</th>
        <th>Estatus</th>
    </tr>
    <c:forEach var="producto" items="${productos}">
        <tr>
            <td>${producto.idProducto}</td>
            <td>${producto.nombreProducto}</td>
            <td>${producto.cantidad}</td>
            <td>${producto.estatus == 1 ? "Activo" : "Inactivo"}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

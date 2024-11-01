<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Historial de Movimientos</title>
</head>
<body>
<h2>Historial de Movimientos</h2>
<form action="historial" method="get">
    <label for="tipo">Filtrar por tipo:</label>
    <select name="tipo" id="tipo">
        <option value="1">Entrada</option>
        <option value="2">Salida</option>
    </select>
    <button type="submit">Filtrar</button>
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>ID Producto</th>
        <th>ID Usuario</th>
        <th>Tipo</th>
        <th>Cantidad</th>
        <th>Fecha</th>
    </tr>
    <c:forEach var="movimiento" items="${movimientos}">
        <tr>
            <td>${movimiento.idMovimiento}</td>
            <td>${movimiento.idProducto}</td>
            <td>${movimiento.idUsuario}</td>
            <td>${movimiento.idTipoMovimiento == 1 ? "Entrada" : "Salida"}</td>
            <td>${movimiento.cantidad}</td>
            <td>${movimiento.fecha}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

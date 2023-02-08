<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.uniovi.sdi.* , java.util.List"%>

<html lang="en">
<head>
    <title>Servlets</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Contenido -->
<div class="container" id="main-container">
    <h2>Vista Productos</h2>
    <ul>
        <c:forEach var="item" items="${storeProducts}">
            <tr>
                <li>${item.getName()} - ${item.getPrice()}</li>
                <img src="<c:out value="${item.getImage()}"/>"/>
            </tr>
        </c:forEach>
    </ul>
    <a href="index.jsp">Volver</a>
</div>
</body>
</html>

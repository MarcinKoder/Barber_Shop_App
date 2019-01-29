<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XxX
  Date: 29.01.2019
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        td:nth-child(4):after{
            content: "PLN"
        }
        table, th, td {
            border: 1px solid black;
            padding: 8px;
        }
    </style>
    <title>All services</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>Lp.</th>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Cena</th>
            <th>Edycja</th>
            <th>Usuwanie</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${services}" var="service" varStatus="stat">
            <tr>
                <td>${stat.index + 1}</td>
                <td>${service.name}</td>
                <td>${service.description}</td>
                <td>${service.price}</td>
                <td><a href="/admin/services/update/${service.id}">Update</a></td>
                <td><a href="/admin/services/delete/${service.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

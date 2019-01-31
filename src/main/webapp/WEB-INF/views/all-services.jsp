<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        .tablediv{
            background-color: rgba(202, 202, 202, 0.9);
            border-radius: 10px
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Cennik</title>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="container">
    <div class="tablediv">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Lp.</th>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Cena</th>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th>Edycja</th>
                <th>Usuwanie</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${services}" var="service" varStatus="stat">
            <tr>
                <td>${stat.index + 1}</td>
                <td>${service.name}</td>
                <td>${service.description}</td>
                <td>${service.price}</td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td><a href="/admin/services/update/${service.id}">Update</a></td>
                <td><a href="/admin/services/delete/${service.id}">Delete</a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>
</body>
</html>

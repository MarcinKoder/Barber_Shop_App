<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XxX
  Date: 05.02.2019
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .tablediv {
        background-color: rgba(202, 202, 202, 0.9);
        border-radius: 10px
    }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>All anonymous orders</title>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="container">
    <div class="tablediv">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Lp.</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Data wizyty</th>
                <th>Edytuj</th>
                <th>Usuń</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${anonymous_orders}" var="order" varStatus="stat">
                <tr>
                    <td>${stat.index + 1}</td>
                    <td>${order.value}</td>
                        <td><a href="/admin/services/update/${order.id}">Edytuj</a></td>
                        <td><a href="/admin/services/delete/${order.id}">Usuń</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

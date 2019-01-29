<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Barber Shop Martino</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Barber Shop Martino</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/home">Home</a></li>
            <li><a href="#">Rezerwacja</a></li>
            <li><a href="#"></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty sessionScope.user}">
                <li><a href="/user/register/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/user/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
                <p class="navbar-text">Witaj ${sessionScope.name}!</p>
                <li><a href="/user/logout" class="button"><span class="glyphicon glyphicon-log-out"></span>Wyloguj się</a></li>
            </c:if>
        </ul>
    </div>
</nav>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        body{
            background-image: url("https://i.pinimg.com/originals/49/3e/ee/493eee832275835f450d1bc0e43f0b48.jpg");
        }
    </style>
    <title>Barber Shop Martino</title>
</head>
<body>
<nav class="navbar navbar-inverse" style="background-color: #00093c">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">Barber Shop Martino</a>
        </div>
            <sec:authorize access="!isAuthenticated()" >
        <ul class="nav navbar-nav">
            <li class="active"><a href="/home">Home</a></li>
            <li class="active"><a href="/order/add">Rezerwacja</a></li>
            <li class="active"><a href="/allservices">Cennik</a></li>
            <li class="active"><a href="/contact">Kontakt</a></li>
            <li class="active"><a href="/about">O nas</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li class="active"><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Home</a></li>
                <sec:authorize access="!hasRole('ROLE_ADMIN')">
                <li class="active"><a href="/user/order/add">Rezerwacja</a></li>
                </sec:authorize>
                <li class="active"><a href="/allservices">Cennik</a></li>
                <li class="active"><a href="/contact">Kontakt</a></li>
                <li class="active"><a href="/about">O nas</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <span class="navbar-text">Witaj <sec:authentication property="name"/>!</span>
                <li class="active"><a href="/logout" class="button"><span class="glyphicon glyphicon-log-out"></span>Wyloguj się</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>
</body>
</html>

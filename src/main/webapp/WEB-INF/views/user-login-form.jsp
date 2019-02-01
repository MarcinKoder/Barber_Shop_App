<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .tablediv {
            background-color: rgba(202, 202, 202, 0.9);
            border-radius: 10px
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Logowanie</title>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="container" align="center">
    <div align="center">
        <div>
            <table class="tablediv" cellpadding="30px" cellspacing="30px">
                <tr>
                    <td align="center">
                        <h3 class="text">Zaloguj się</h3>
                        <div class="text tablediv">
                            <form:form modelAttribute="userDto" method="post" action="/login">
                                <div class="form-group">
                                    <label for="formGroupExampleInput">
                                        Email: <form:input path="email" required="true" class="form-control"
                                                           id="formGroupExampleInput"/><form:errors path="email"/>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label for="formGroupExampleInput">
                                        Hasło: <form:password path="password" required="true" class="form-control"
                                                              id="formGroupExampleInput"/>
                                        <form:errors path="password"/>
                                    </label>
                                </div>
                                <p><input type="submit" class="btn btn-primary btn-sm" value="Zaloguj"></p>
                            </form:form>
                        </div>
                        <hr class="line" style="height:50px; color: rgba(0,0,0,0.87)">
                        <br/>
                        <div>
                            <h3 class="text">Jeśli nie masz konta</h3><br/>
                            <a href="/register" type="button" class="btn btn-primary btn-sm">Zarejetruj się</a>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
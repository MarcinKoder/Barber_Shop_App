<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: XxX
  Date: 30.01.2019
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        input:invalid + span:after {
            content: '✖';
            padding-left: 5px;
        }

        input:valid + span:after {
            content: '✓';
            padding-left: 5px;
        }

        .tablediv {
            background-color: rgba(202, 202, 202, 0.9);
            border-radius: 10px
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Rezerwacja</title>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="container">
    <div class="tablediv" align="center">
        <form:form modelAttribute="userOrder" method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">
                    Imię : <form:input readonly="true" path="user.name" class="form-control"
                                       id="formGroupExampleInput"/><form:errors path="user.name"/>
                </label>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput">
                    Nazwisko: <form:input readonly="true" path="user.surname" class="form-control"
                                          id="formGroupExampleInput"/><form:errors path="user.surname"/>
                </label>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput">
                    Email: <form:input readonly="true" path="user.email" class="form-control"
                                       id="formGroupExampleInput"/><form:errors path="user.email"/>
                </label>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput">
                    Usługa: <form:select path="service"
                                         items="${services}"
                                         itemLabel="name"
                                         itemValue="id"
                                         class="custom-select mr-sm-2"
                                         id="inlineFormCustomSelect"/><form:errors path="service"/>
                </label>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput">Wybierz datę i godzinę:
                <form:input id="party"
                            path="dateOfOrderContract"
                            type="datetime-local"
                            step="1800"
                            min="${now}"
                            max="${max}"
                            required="true"
                />
                <span class="validity"></span>
                </label>
                    <%--items="${listOfVisitHours}"--%>
                    <%--itemLabel="desc"--%>
                    <%--itemValue="dateOfOrderContract"--%>
                    <%--class="custom-select mr-sm-2"--%>
                    <%--id="inlineFormCustomSelect"/>--%>
            </div>
            <p><input type="submit" class="btn btn-primary btn-sm" value="Zatwierdź"/></p>
        </form:form>
    </div>
</div>
</body>
</html>

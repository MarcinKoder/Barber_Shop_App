<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: XxX
  Date: 30.01.2019
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rezerwacja</title>
    <style>
        .tablediv{
            background-color: rgba(202, 202, 202, 0.81);
            border-radius: 50px
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="container">
    <div align="center">
        <div class="tablediv">
        <table>
            <tr>
                <td class="col-sm-6" style="padding: 120px">
                    <form:form modelAttribute="anonOrder" method="post">
                        <div class="form-group">
                            <label for="formGroupExampleInput">
                                Imię : <form:input path="name" class="form-control"
                                                   id="formGroupExampleInput"/><form:errors path="name"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">
                                Nazwisko: <form:input path="surname" class="form-control"
                                                      id="formGroupExampleInput"/><form:errors path="surname"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">
                                Email: <form:input path="email" class="form-control"
                                                   id="formGroupExampleInput"/><form:errors path="email"/>
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
                </td>
                <td class="col-sm-6" style="padding: 150px; border-left: 5px solid #51534c;">
                    <h3 class="text">Lub zarejestruj się</h3><br/>
                    <a href="/register" type="button" class="btn btn-primary btn-sm">Zarejetruj się</a>
                </td>
            </tr>
        </table>
        </div>
    </div>
</div>
</body>
</html>

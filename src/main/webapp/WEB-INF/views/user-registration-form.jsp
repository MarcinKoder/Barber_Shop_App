<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .tablediv {
            background-color: rgba(202, 202, 202, 0.9);
            border-radius: 10px;
            padding: 30px;
        }
        td{
            padding: 40px;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Zarejestruj się</title>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="container" align="center">
    <div align="center">
        <div>
        <table class="tablediv" cellpadding="30px" cellspacing="30px">
            <tr>
                <td align="center">
                    <h3> Zarejestruj się</h3>
                    <form:form modelAttribute="registrationForm" method="post">
                        <div class="form-group">
                            <label for="formGroupExampleInput">
                                Imię: <form:input path="name" required="true" type="text" class="form-control"
                                                  id="formGroupExampleInput"/><form:errors path="name"/>
                            </label>
                        </div>
                        <div class="form-group" style="padding: 30px">
                            <label for="formGroupExampleInput">
                                Nazwisko: <form:input path="surname" required="true" type="text" class="form-control"
                                                      id="formGroupExampleInput"/><form:errors path="surname"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">
                                Email: <form:input path="email" required="true" type="text" class="form-control"
                                                   id="formGroupExampleInput"/><form:errors path="email"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">
                                Hasło: <form:password path="password" required="true" class="form-control"
                                                      id="formGroupExampleInput"/><form:errors path="password"/>
                            </label>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">
                                Powtórz hasło: <form:password path="confirmPassword" required="true"
                                                              class="form-control"
                                                              id="formGroupExampleInput"/><form:errors
                                    path="confirmPassword"/>
                            </label>
                        </div>
                        <p><input class="btn btn-primary btn-sm" type="submit" value="Zarejestruj"/></p>
                    </form:form>
                </td>
            </tr>
        </table>
        </div>
    </div>
</div>
</body>
</html>

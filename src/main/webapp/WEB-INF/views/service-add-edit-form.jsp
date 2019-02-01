<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Service</title>
    <style>
        .tablediv{
            background-color: rgba(202, 202, 202, 0.81);
            border-radius: 20px;
            background-size: 50px 50px;
        }
    </style>
</head>
<body>
<jsp:include page="home.jsp"/>
<div class="container">
    <div align="center">
        <div class="tablediv">
            <table>
                <tr>
                    <td class="col-sm-6" style="padding: 120px">
    <form:form modelAttribute="service" method="post">
        <div class="form-group">
            <label for="formGroupExampleInput">
        Nazwa usługi: <form:input path="name" class="form-control"
                                     id="formGroupExampleInput"/><form:errors path="name"/>
            </label>
        </div>
        <div class="form-group">
            <label for="formGroupExampleInput">
        Opis : <form:textarea path="description" class="form-control"
                                 id="formGroupExampleInput"/><form:errors path="description"/>
            </label>
        </div>
        <div class="form-group">
            <label for="formGroupExampleInput">
        Cena usługi: <form:input path="price" type="currency" class="form-control"
                                    id="formGroupExampleInput"/><form:errors path="price"/>
            </label>
        </div>
        <p><input type="submit" value="Zapisz"/><input type="reset" value="Wyczyść"></p>
    </form:form>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>

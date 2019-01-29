<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Service</title>
</head>
<body>
<div>
    <form:form modelAttribute="service" method="post">
        <p>Nazwa usługi: <form:input path="name"/><form:errors path="name"/></p>
        <p>Opis : <form:textarea path="description"/><form:errors path="description"/></p>
        <p>Cena usługi: <form:input path="price" type="currency"/><form:errors path="price"/></p>
        <p><input type="submit" value="Zapisz"/><input type="reset" value="Wyczyść"></p>
    </form:form>
</div>
</body>
</html>

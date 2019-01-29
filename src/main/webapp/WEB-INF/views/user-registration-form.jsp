<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarejestruj się</title>
</head>
<body>
<div>
    <h3>Zarejestruj się</h3>
    <div>
        <form:form modelAttribute="newUser" method="post">
            <p>Imię: <form:input path="name" required="true"/><form:errors path="name"/></p>
            <p>Nazwisko: <form:input path="surname" required="true"/><form:errors path="surname"/></p>
            <p>Email: <form:input path="email" required="true"/><form:errors path="email"/></p>
            <p>Hasło: <form:password path="password" required="true"/><form:errors path="password"/></p>
            <p><input type="submit" value="Zarejestruj"/></p>
        </form:form>
    </div>
</div>
</body>
</html>

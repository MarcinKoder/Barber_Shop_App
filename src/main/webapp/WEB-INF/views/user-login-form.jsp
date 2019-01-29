<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<html>
<head>
    <title>Logowanie</title>
</head>
<body style="text-align: center">
<jsp:include page="home.jsp"/>
<div>
    <h3 class="text">Zaloguj się</h3>
    <div class="text">
        <form:form modelAttribute="userDto" method="post">
            <p>Email: <form:input path="email" required="true"/></p>
            <p>Hasło: <form:password path="password" required="true"/>
                <form:errors path="password" cssClass="error"/></p>
            <p><input type="submit" value="Zaloguj"></p>
        </form:form>
    </div>
</div>
<hr class="line">
<br/>
<div>
    <h3 class="text">lub, jeśli nie masz konta:</h3><br/>
    <a href="/register" class="button">zarejetruj się</a>
</div>
</body>
</html>
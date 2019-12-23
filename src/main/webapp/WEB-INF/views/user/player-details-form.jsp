<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 23/12/2019
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="singlesPlayerDetails">
    <p>Imię: <form:input path="firstName"/><form:errors path="firstName"/></p>
    <p>Nazwisko: <form:input path="lastName"/><form:errors path="lastName"/></p>
    <p>Numer telefonu: <form:input path="phoneNumber"/><form:errors path="phoneNumber"/></p>
    <p>Poziom NTRP: <form:select path="ntrp">
        <form:option value="-" label="--Wybierz NTRP--"/>
        <form:options items="${ntrplevels}"/>
    </form:select> </p>
    <p><input type="submit" value="Dołącz"></p>
</form:form>
</body>
</html>

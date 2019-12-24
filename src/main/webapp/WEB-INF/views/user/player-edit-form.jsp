<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 24/12/2019
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja profilu gracza</title>
</head>
<body>
<form:form method="post" modelAttribute="singlesPlayerEditDTO">
    <p><form:hidden path="id"/></p>
    <p><form:hidden path="userId"/></p>
    <p><form:hidden path="roundId"/></p>
    <p><form:hidden path="groupId"/></p>
    <p><form:hidden path="totalMatchesLost"/></p>
    <p><form:hidden path="totalPoints"/></p>
    <p><form:hidden path="totalSetsWon"/></p>
    <p><form:hidden path="totalMatchesWon"/></p>
    <p><form:hidden path="notes"/></p>
    <p><form:hidden path="active"/></p>
    <p>Imię: <form:input path="firstName"/><form:errors path="firstName"/></p>
    <p>Nazwisko: <form:input path="lastName"/><form:errors path="lastName"/></p>
    <p>Numer telefonu: <form:input path="phoneNumber"/><form:errors path="phoneNumber"/></p>
    <p>Poziom NTRP: <form:select path="ntrp">
        <form:options items="${ntrplevels}"/>
    </form:select> </p><form:errors path="ntrp"/>
    <p><input type="submit" value="Edytuj"></p>
</form:form>
</body>
</html>

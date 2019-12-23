<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 10/12/2019
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja gracza singlowego w rundzie</title>
</head>
<body>
<form:form method="post" modelAttribute="singlesPlayer">
    <p>Zapis do rundy ${soonestround.name} rozpoczynającej się ${soonestround.startDate} i kończącej ${soonestround.endDate}</p>
    <p><form:hidden path="id"/></p>
    <p><form:hidden path="roundId" value="${soonestround.id}" readonly="true"/></p>
    <p>Imię: <form:input path="firstName"/><form:errors path="firstName"/></p>
    <p>Nazwisko: <form:input path="lastName"/><form:errors path="lastName"/></p>
    <p>Numer telefonu: <form:input path="phoneNumber"/><form:errors path="phoneNumber"/></p>
    <p>Poziom NTRP: <form:select path="ntrp">
        <form:option value="-" label="--Wybierz NTRP--"/>
        <form:options items="${ntrplevels}"/>
    </form:select> </p>
    <c:choose>
        <c:when test="${singlesPlayer.roundId == null}">
            <c:choose>
                <c:when test="${soonestround.startDate > registerLimit}">
                    <p><input type="submit" value="Dołącz"></p>
                </c:when>
                <c:otherwise>
                    <p>Zapisy do tej rundy zakończone/Użytkownik już zapisany</p>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <p>Użytkownik już jest zapisany do rundy</p>
        </c:otherwise>
    </c:choose>
</form:form>
</body>
</html>

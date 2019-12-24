<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 24/12/2019
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="singlesPlayerSignUp">
    <p>Zapis do rundy ${soonestround.name} rozpoczynającej się ${soonestround.startDate} i kończącej ${soonestround.endDate}</p>
    <p><form:hidden path="id"/></p>
    <p><form:hidden path="roundId" value="${soonestround.id}" readonly="true"/></p>
    <p><form:hidden path="userId"/></p>
    <p>Imię: <form:input path="firstName" readonly="true"/><form:errors path="firstName"/></p>
    <p>Nazwisko: <form:input path="lastName" readonly="true"/><form:errors path="lastName"/></p>
    <p>Numer telefonu: <form:input path="phoneNumber" readonly="true"/><form:errors path="phoneNumber"/></p>
    <p>Poziom NTRP: <form:input path="ntrp" readonly="true"/>
        <c:choose>
            <c:when test="${soonestround.startDate > registerLimit}">
                <p><input type="submit" value="Dołącz"></p>
            </c:when>
            <c:otherwise>
                <p>Zapisy do tej rundy zakończone</p>
            </c:otherwise>
        </c:choose>
</form:form>
</body>
</html>

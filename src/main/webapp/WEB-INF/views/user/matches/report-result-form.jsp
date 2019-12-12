<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/12/2019
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj wynik</title>
</head>
<body>

<form:form method="post" modelAttribute="match">
    <p>Nazwisko zalogowanego użytkownika: <form:input path="playerOneId" readonly="true"/></p>
    <p>Nazwisko zalogowanego zawodnika: ${match.playerOneId}</p>
    <p>Wynik zalogowanego zawodnika: <form:select path="playerOneSets" items="${sets}"/></p>
    <p>Nazwisko przeciwnika: <form:input path="playerTwoId" readonly="true"/> </p>
    <p>Nazwisko zalogowanego zawodnika: ${match.playerTwoId}</p>
    <p>Wynik przeciwnika: <form:select path="playerOneSets" items="${sets}"/></p>
    <p><input type="submit" value="Zapisz wynik"></p>
</form:form>
</body>
</html>

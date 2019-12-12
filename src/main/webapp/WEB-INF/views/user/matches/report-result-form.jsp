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
    <form:hidden path="id"/>
    <p>Pierwszy zawodnik: ${match.playerOneLastName}</p>
    <p>Wynik pierwszego zawodnika: <form:select path="playerOneSets" items="${sets}"/></p>
    <p>Drugi zawodnik: ${match.playerTwoLastName}</p>
    <p>Wynik drugiego zawodnika: <form:select path="playerTwoSets" items="${sets}"/></p>
    <p><input type="submit" value="Zapisz wynik"></p>
</form:form>
</body>
</html>

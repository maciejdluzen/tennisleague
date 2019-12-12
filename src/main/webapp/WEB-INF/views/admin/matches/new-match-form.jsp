<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie meczu</title>
</head>
<body>
<form:form method="post" modelAttribute="newMatch">
    <p>Zawodnik 1: <form:select path="playerOneId" items="${allsinglesplayers}" itemLabel="lastName" itemValue="id"/></p>
    <p>Zawodnik 2: <form:select path="playerTwoId" items="${allsinglesplayers}" itemLabel="lastName" itemValue="id"/></p>
    <p><input type="submit" value="Utwórz mecz"></p>
</form:form>
</body>
</html>

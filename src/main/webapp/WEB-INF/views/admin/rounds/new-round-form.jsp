<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tworzenie nowej rundy</title>
</head>
<body>
<form:form method="post" modelAttribute="newRound">
    <p>Nazwa rundy: <form:input path="name"/><form:errors path="name"/></p>
    <p>Data rozpoczęcia: <form:input path="startDate" type="date" dataType="rrrr-MM-dd"/><form:errors path="startDate"/></p>
    <p>Data zakończenia <form:input path="endDate" type="date" dataType="rrrr-MM-dd"/><form:errors path="endDate"/></p>
    <p>Środek rundy: <form:input path="midpointDate" type="date" dataType="rrrr-MM-dd"/><form:errors path="midpointDate"/></p>
    <p>Data zakończenia zapisów: <form:input path="joinByDate" type="date" dataType="rrrr-MM-dd"/><form:errors path="joinByDate"/></p>
    <p><input type="submit" value="Utwórz rundę"></p>
</form:form>
</body>
</html>

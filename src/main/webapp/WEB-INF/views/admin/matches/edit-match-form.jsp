<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 16/12/2019
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja meczu</title>
</head>
<body>
<form:form method="post" modelAttribute="editMatch">
    <p><form:hidden path="id"/></p>
    <p><form:select path="groupId" items="${allgroups}" itemLabel="name" itemValue="id"/></p>
    <p><form:hidden path="playerOne"/></p>
    <p><form:hidden path="playerTwo"/></p>
    <p>Nazwisko zawodnika 1 ${editMatch.playerOne.firstName} + " " + ${editMatch.playerOne.lastName}</p>
    <p>Nazwisko zawodnika 2 ${editMatch.playerTwo.firstName} + " " + ${editMatch.playerTwo.lastName} </p>
    <p>Liczba setów zawodnika 1 <form:select path="playerOneSets" items="${sets}"/><form:errors path="playerOneSets"/></p>
    <p>Liczba setów zawodnika 2 <form:select path="playerTwoSets" items="${sets}"/><form:errors path="playerTwoSets"/></p>
    <p><input type="submit" value="Zatwierdź"></p>
</form:form>
</body>
</html>

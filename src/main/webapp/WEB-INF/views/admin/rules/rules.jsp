<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 17/01/2020
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zasady Ligi Tenisowej</title>
</head>
<body>
<table>
    <tr>
        <td>Lp.</td>
        <td>Treść zasady</td>
    </tr>
    <c:forEach items="${allrules}" var="rule">
        <tr>
            <td>${rule.number}</td>
            <td>${rule.description}</td>
        </tr>
    </c:forEach>
</table>
<form:form method="post" modelAttribute="newRule">
    <label>Numer zasady</label>
    <form:input path="number"/>
    <form:errors path="number"/>
    <label>Opis</label>
    <form:textarea path="description"/>
    <form:errors path="description"/>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>

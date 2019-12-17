<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 17/12/2019
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja grupy</title>
</head>
<body>
<form:form method="post" modelAttribute="editGroup">
    <p><form:hidden path="id"/></p>
    <p>Nazwa grupy: <form:input path="name"/><form:errors path="name"/></p>
    <p>Nazwa rundy: <form:select path="roundId" items="${allrounds}" itemLabel="name" itemValue="id"/></p>
    <p><input type="submit" value="Zatwierdź"</p>
</form:form>
</body>
</html>

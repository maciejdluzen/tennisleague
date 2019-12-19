<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 19/12/2019
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie zawodnika</title>
</head>
<body>
<h2>Potwierdź, czy chcesz kontynuować:</h2>
<form method="get" action="/admin/singlesplayers">
    <input class="button is-warning" type="submit" value="Anuluj"/>
</form>

<form method="post">
    <input type="hidden" name="id" value="${id}"/>
    <input class="button is-danger" type="submit" value="Usuń"/>
    <sec:csrfInput/>
</form>
</body>
</html>

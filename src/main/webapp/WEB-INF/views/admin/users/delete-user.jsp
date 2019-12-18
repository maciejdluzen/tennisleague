<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 18/12/2019
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie usunięcia użytkownika</title>
</head>
<body>
<h2>Uwaga!</h2>
<p>Usunięcie użytkownika spowoduje następujące nieodwracalne akcje:</p>
<ul>
    <li>Usunięcie zawodnika przypisanego do użytkownika</li>
    <li>Usunięcie wszystkich meczów użytkownika</li>
</ul>

<h2>Powtierdź, czy chcesz kontynuować:</h2>
<form method="get" action="/admin/users">
    <input class="button is-warning" type="submit" value="Anuluj"/>
</form>

<form method="post">
    <input type="hidden" name="id" value="${id}"/>
    <input class="button is-danger" type="submit" value="Usuń"/>
    <sec:csrfInput/>
</form>
</body>
</html>

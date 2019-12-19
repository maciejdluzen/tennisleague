<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 18/12/2019
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista zarejestrowanych użytkowników</title>
</head>
<body>
<header class="hero-body">
    <div class="column center">
        <table class="table">
            <tr>
                <td>Lp.</td>
                <td>ID użytkownika</td>
                <td>Nazwa użytkownika</td>
                <td>Adres email</td>
                <td>Active</td>
                <td>ID gracza</td>
                <td>Imię i nazwisko gracza</td>
            </tr>
            <c:forEach items="${allUsers}" var="user" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.active}</td>
                    <td>${user.singlesPlayer.id}</td>
                    <td>${user.singlesPlayer.firstName} ${user.singlesPlayer.lastName}</td>
                    <td>
                        <c:url value="/admin/users/delete" var="deleteURL">
                            <c:param name="id" value="${user.id}"/>
                        </c:url>
                        <c:choose>
                            <c:when test="${user.active.equals(true)}">
                                <c:url value="/admin/users/deactivateuser" var="deactivateuserURL">
                                    <c:param name="id" value="${user.id}"/>
                                </c:url>
                                <a href="${deactivateuserURL}">Dezaktywuj</a>
                            </c:when>
                            <c:otherwise>
                                <c:url value="/admin/users/activateuser" var="activateuserURL">
                                    <c:param name="id" value="${user.id}"/>
                                </c:url>
                                <a href="${activateuserURL}">Aktywuj</a>
                            </c:otherwise>
                        </c:choose>
                        <a href="${deleteURL}">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</header>
</body>
</html>

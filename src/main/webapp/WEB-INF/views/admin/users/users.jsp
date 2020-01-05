<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <link href="public_html/styles/bulma.css" rel="stylesheet" type="text/css">
    <link href="public_html/styles/helpers.css" rel="stylesheet" type="text/css">
    <link href="public_html/styles/grid.css" rel="stylesheet" type="text/css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<!-- Header -->
<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <div class="navbar-item is-size-3 has-text-grey-bold">
                <p>WROCŁAWSKA LIGA TENISOWA</p>
            </div>
        </div>
        <div class="navbar-menu">
            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="buttons">
                        <form>
                            <a class="navbar-item button" href="/admin" style="margin-right: 1em;"><strong>Powrót</strong></a>
                        </form>
                        <form>
                            <a class="navbar-item button" href="/" style="margin-right: 1em;"><strong>Strona główna</strong></a>
                        </form>
                        <form method="post" action="/logout">
                            <button class="button is-primary" type="submit"><strong>Wyloguj</strong></button>
                            <sec:csrfInput/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
<!-- HeaderEND -->
<section class="section">
    <div class="container">
        <div class="columns">
            <!-- Admin panel on the left-->
            <div class="column is-3 has-background-primary">
                <aside class="menu is-hidden-mobile">
                    <p class="menu-label">
                        General
                    </p>
                    <ul class="menu-list">
                        RUNDY
                        <li><a href="/admin/rounds">Przeglądaj</a></li>
                        <li><a href="/admin/rounds/add">Dodaj</a></li>
                        GRUPY
                        <li><a href="/admin/groups">Przeglądaj</a></li>
                        <li><a href="/admin/groups/add">Dodaj</a></li>
                        MECZE
                        <li><a href="/admin/matches">Przeglądaj</a></li>
                        <li><a href="/admin/matches/add">Dodaj</a></li>
                        ZAWODNICY
                        <li><a href="/admin/singlesplayers">Przeglądaj</a></li>
                        UŻYTKOWNICY
                        <li><b>Przeglądaj</b></li>
                    </ul>
                </aside>
            </div>
            <!-- Admin panel on the leftEND-->
            <!-- Users section info -->
            <div class="column is-9">
                <section class="hero is-info welcome">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                Zarejestrowani użytkownicy
                            </h1>
                        </div>
                    </div>
                </section>
                <!-- Users section infoEND -->
                <!-- Users table -->
                <div class="column">
                    <div class="card-table">
                        <div class="content">
                            <table class="table is-fullwidth is-striped">
                                <tbody>
                                <tr>
                                    <td>Lp.</td>
                                    <td>ID</td>
                                    <td>Active</td>
                                    <td>Nazwa użytkownika</td>
                                    <td>Adres email</td>
                                    <td>ID zawodnika</td>
                                    <td>Imię i nazwisko zawodnika</td>
                                </tr>
                                <c:forEach items="${allUsers}" var="user" varStatus="stat">
                                    <tr>
                                        <td>${stat.count}</td>
                                        <td>${user.id}</td>
                                        <c:choose>
                                            <c:when test="${user.active}">
                                                <td><i class="fas fa-check"></i></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><i class="fas fa-minus"></i></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>${user.username}</td>
                                        <td>${user.email}</td>
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
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- Users tableEND -->
                <div class="columns">
                    <div class="column is-6">
                        <div class="card events-card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    Informacje dotyczące użytkowników
                                </p>
                            </header>
                            <div class="card-table">
                                <tr>
                                    <ul>
                                        <li>Dezaktywacja użytkownika powoduje brak możliwości zalogowania do konta danego użytkownika</li>
                                    </ul>
                                </tr>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>






<%--<header class="hero-body">--%>
<%--    <div class="column center">--%>
<%--        <table class="table">--%>
<%--            <tr>--%>
<%--                <td>Lp.</td>--%>
<%--                <td>ID użytkownika</td>--%>
<%--                <td>Nazwa użytkownika</td>--%>
<%--                <td>Adres email</td>--%>
<%--                <td>Active</td>--%>
<%--                <td>ID gracza</td>--%>
<%--                <td>Imię i nazwisko gracza</td>--%>
<%--            </tr>--%>
<%--            <c:forEach items="${allUsers}" var="user" varStatus="stat">--%>
<%--                <tr>--%>
<%--                    <td>${stat.count}</td>--%>
<%--                    <td>${user.id}</td>--%>
<%--                    <td>${user.username}</td>--%>
<%--                    <td>${user.email}</td>--%>
<%--                    <td>${user.active}</td>--%>
<%--                    <td>${user.singlesPlayer.id}</td>--%>
<%--                    <td>${user.singlesPlayer.firstName} ${user.singlesPlayer.lastName}</td>--%>
<%--                    <td>--%>
<%--                        <c:url value="/admin/users/delete" var="deleteURL">--%>
<%--                            <c:param name="id" value="${user.id}"/>--%>
<%--                        </c:url>--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${user.active.equals(true)}">--%>
<%--                                <c:url value="/admin/users/deactivateuser" var="deactivateuserURL">--%>
<%--                                    <c:param name="id" value="${user.id}"/>--%>
<%--                                </c:url>--%>
<%--                                <a href="${deactivateuserURL}">Dezaktywuj</a>--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <c:url value="/admin/users/activateuser" var="activateuserURL">--%>
<%--                                    <c:param name="id" value="${user.id}"/>--%>
<%--                                </c:url>--%>
<%--                                <a href="${activateuserURL}">Aktywuj</a>--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
<%--                        <a href="${deleteURL}">Usuń</a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--    </div>--%>
<%--</header>--%>

</body>
</html>

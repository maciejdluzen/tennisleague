<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona administratora</title>
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
                            <a class="navbar-item button" href="/admin" style="margin-right: 1em;"><strong>Strona admina</strong></a>
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
            <!-- Admin panel on the right-->
            <div class="column is-3 has-background-primary">
                <aside class="menu is-hidden-mobile">
                    <p class="menu-label">
                        General
                    </p>
                    <ul class="menu-list">
                        RUNDY
                        <li><b>Przeglądaj</b></li>
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
                        <li><a href="/admin/users">Przeglądaj</a></li>
                    </ul>
                </aside>
            </div>
            <!-- Admin panel on the rightEND-->
        </div>
    </div>
</section>










<!--. hero -->
<section class="hero is-fullheight">
    <!--.hero-head-->
    <div class="hero-head">
        <div class="columns is-mobile is-marginless heading has-text-weight-bold">
            <div class="column left">
                <p class="navbar-item is-size-3 has-text-grey-light">ZARZĄDZANIE RUNDAMI</p>
                <!-- ... -->
            </div>
            <div class="column center desktop">
                <a class="navbar-item has-text-black is-size-5" href="/admin/rounds/add">DODAJ RUNDĘ</a>
                <!-- ... -->
            </div>
            <div class="column right">
                <a class="navbar-item desktop has-text-black is-size-5" href="/">STRONA GŁÓWNA</a>
                <form method="post" action="/logout">
                    <button class="navbar-item desktop has-text-black is-size-5" type="submit">WYLOGUJ</button>
                    <sec:csrfInput/>
                </form>
                <!-- ... -->
            </div>
        </div>
    </div>
    <!-- /. hero-head-->
    <!-- .hero-body-->
    <header class="hero-body">
        <div class="column center">
            <table class="table">
                <tr>
                    <td>Lp.</td>
                    <td>ID rundy</td>
                    <td>Nazwa rundy</td>
                    <td>Data rozpoczęcia</td>
                    <td>Data zakończenia</td>
                    <td>Środek rundy</td>
                    <td>Zakończenie zapisów</td>
                    <td>Runda aktywna</td>
                    <td>Akcje</td>
                </tr>
                <c:forEach items="${allrounds}" var="round" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                        <td>${round.id}</td>
                        <td>${round.name}</td>
                        <td>${round.startDate}</td>
                        <td>${round.endDate}</td>
                        <td>${round.midpointDate}</td>
                        <td>${round.joinByDate}</td>
                        <td>${round.current}</td>
                        <td>
                            <c:url value="/admin/rounds/delete" var="deleteURL">
                                <c:param name="id" value="${round.id}"/>
                            </c:url>
                            <c:url value="/admin/rounds/edit" var="updateURL">
                                <c:param name="id" value="${round.id}"/>
                            </c:url>
                            <a href="${deleteURL}">Usuń</a>
                            <a href="${updateURL}">Edytuj</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </header>
</section>
</body>
</html>

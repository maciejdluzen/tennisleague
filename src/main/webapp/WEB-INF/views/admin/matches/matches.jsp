<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie meczami</title>
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
                        <li><b>Przeglądaj</b></li>
                        <li><a href="/admin/matches/add">Dodaj</a></li>
                        ZAWODNICY
                        <li><a href="/admin/singlesplayers">Przeglądaj</a></li>
                        UŻYTKOWNICY
                        <li><a href="/admin/users">Przeglądaj</a></li>
                    </ul>
                </aside>
            </div>
            <!-- Admin panel on the leftEND-->
            <!-- Matches section info -->
            <div class="column is-9">
                <section class="hero is-info welcome">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                Przeglądanie meczy w obecnej rundzie
                            </h1>
                        </div>
                    </div>
                </section>
                <!-- Matches section info -->
                <!-- Matches table -->
                <div class="column">
                    <div class="card events-card">
                        <header class="card-header">
                            <p class="card-header-title">
                                Wszystkie mecze
                            </p>
                        </header>
                        <div class="card-table">
                            <div class="content">
                                <table class="table is-fullwidth is-striped">
                                    <tbody>
                                    <tr>
                                        <td>Lp.</td>
                                        <td>ID</td>
                                        <td>Grupa</td>
                                        <td>Data meczu</td>
                                        <td>Zawodnik 1</td>
                                        <td>Wygrane sety</td>
                                        <td>Zawodnik 2</td>
                                        <td>Wygrane sety</td>
                                        <td>Akcje</td>
                                    </tr>
                                    <c:forEach items="${allmatches}" var="match" varStatus="stat">
                                        <tr>
                                            <td>${stat.count}</td>
                                            <td>${match.id}</td>
                                            <td>${match.group.name}</td>
                                            <td>${match.dateOfGame}</td>
                                            <td>${match.playerOne.lastName}</td>
                                            <td>${match.playerOneSets}</td>
                                            <td>${match.playerTwo.lastName}</td>
                                            <td>${match.playerTwoSets}</td>
                                            <td>
                                                <c:url value="/admin/matches/delete" var="deleteURL">
                                                    <c:param name="id" value="${match.id}"/>
                                                </c:url>
                                                <c:url value="/admin/matches/edit" var="updateURL">
                                                    <c:param name="id" value="${match.id}"/>
                                                </c:url>
                                                <a href="${deleteURL}">Usuń</a>
                                                <a href="${updateURL}">Edytuj</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Matches tableEND -->
                <div class="columns">
                    <div class="column is-6">
                        <div class="card events-card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    Informacje dotyczące meczy:
                                </p>
                            </header>
                            <div class="card-table">
                                <tr>
                                    <ul>
                                        <li>Info-1</li>
                                        <li>Info-2</li>
                                        <li>Info-3</li>
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

<%--<section class="hero is-fullheight">--%>
<%--    <!--.hero-head-->--%>
<%--    <div class="hero-head">--%>
<%--        <div class="columns is-mobile is-marginless heading has-text-weight-bold">--%>
<%--            <div class="column left">--%>
<%--                <p class="navbar-item is-size-3 has-text-grey-light">ZARZĄDZANIE MECZAMI</p>--%>
<%--                <!-- ... -->--%>
<%--            </div>--%>
<%--            <div class="column center desktop">--%>
<%--                <a class="navbar-item has-text-black is-size-5" href="/admin/matches/add">DODAJ MECZ</a>--%>
<%--                <!-- ... -->--%>
<%--            </div>--%>
<%--            <div class="column right">--%>
<%--                <a class="navbar-item desktop has-text-black is-size-5" href="/">STRONA GŁÓWNA</a>--%>
<%--                <form method="post" action="/logout">--%>
<%--                    <button class="navbar-item desktop has-text-black is-size-5" type="submit">WYLOGUJ</button>--%>
<%--                    <sec:csrfInput/>--%>
<%--                </form>--%>
<%--                <!-- ... -->--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!-- /. hero-head-->--%>
<%--    <!-- .hero-body-->--%>
<%--    <header class="hero-body">--%>
<%--        <div class="column center">--%>
<%--            <table class="table">--%>
<%--                <tr>--%>
<%--                    <td>Lp.</td>--%>
<%--                    <td>ID meczu</td>--%>
<%--                    <td>Grupa</td>--%>
<%--                    <td>Data meczu</td>--%>
<%--                    <td>Zawodnik 1</td>--%>
<%--                    <td>Liczba wygranych setów</td>--%>
<%--                    <td>Zawodnik 2</td>--%>
<%--                    <td>Liczba wygranych setów</td>--%>
<%--                </tr>--%>
<%--                <c:forEach items="${allmatches}" var="match" varStatus="stat">--%>
<%--                    <tr>--%>
<%--                        <td>${stat.count}</td>--%>
<%--                        <td>${match.id}</td>--%>
<%--                        <td>${match.group.name}</td>--%>
<%--                        <td>${match.dateOfGame}</td>--%>
<%--                        <td>${match.playerOne.lastName}</td>--%>
<%--                        <td>${match.playerOneSets}</td>--%>
<%--                        <td>${match.playerTwo.lastName}</td>--%>
<%--                        <td>${match.playerTwoSets}</td>--%>
<%--                        <td>--%>
<%--                            <c:url value="/admin/matches/delete" var="deleteURL">--%>
<%--                                <c:param name="id" value="${match.id}"/>--%>
<%--                            </c:url>--%>
<%--                            <c:url value="/admin/matches/edit" var="updateURL">--%>
<%--                                <c:param name="id" value="${match.id}"/>--%>
<%--                            </c:url>--%>
<%--                            <a href="${deleteURL}">Usuń</a>--%>
<%--                            <a href="${updateURL}">Edytuj</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </header>--%>
<%--</section>--%>

</body>
</html>

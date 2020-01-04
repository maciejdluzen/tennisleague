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
            <!-- Admin panel on the leftEND-->
            <!-- Rounds section info -->
            <div class="column is-9">
                <section class="hero is-info welcome">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                Przeglądanie rund w lidze
                            </h1>
                        </div>
                    </div>
                </section>
                <!-- Rounds section info -->
                <!-- Rounds table -->
                <div class="column">
                    <div class="card events-card">
                        <header class="card-header">
                            <p class="card-header-title">
                                Wszystkie rundy
                            </p>
                        </header>
                        <div class="card-table">
                            <div class="content">
                                <table class="table is-fullwidth is-striped">
                                    <tbody>
                                    <tr>
                                        <td>Lp.</td>
                                        <td>ID rundy</td>
                                        <td>Nazwa rundy</td>
                                        <td>Data rozpoczęcia</td>
                                        <td>Środek rundy</td>
                                        <td>Data zakończenia</td>
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
                                            <td>${round.midpointDate}</td>
                                            <td>${round.endDate}</td>
                                            <td>${round.joinByDate}</td>
                                            <c:choose>
                                                <c:when test="${round.current}">
                                                    <td><i class="fas fa-check"></i></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><i class="fas fa-minus"></i></td>
                                                </c:otherwise>
                                            </c:choose>
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
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Rounds tableEND -->
                <div class="columns">
                    <div class="column is-6">
                        <div class="card events-card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    Informacje dotyczące rund:
                                </p>
                            </header>
                            <div class="card-table">
                                <tr>
                                    <ul>
                                        <li>Zakończenie zapisów do rundy powinno odbywać się na 2 dni przed rozpoczęciem rundy</li>
                                        <li>Tylko jedna runda może być ustawiona jako aktywna w jednym momencie</li>
                                        <li>Gracz musi rozegrać przynajmniej 3 mecze do daty 'środka' rundy, aby otrzymać 2 bonusowe punkty</li>
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
</body>
</html>

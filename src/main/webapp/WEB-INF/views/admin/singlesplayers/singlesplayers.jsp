<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie zawodnikami singlowymi</title>
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
            <div class="column is-12">
                <section class="hero is-info welcome">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                Zawodnicy
                            </h1>
                        </div>
                    </div>
                </section>
                <!-- Singles players section info -->
                <!-- Singles players table -->
                <div class="column">
                    <div class="card events-card">
                        <header class="card-header">
                            <p class="card-header-title">
                                Wszyscy zawodnicy
                            </p>
                        </header>
                        <div class="card-table">
                            <div class="content">
                                <table class="table is-fullwidth is-striped">
                                    <thead>
                                        <tr>
                                            <th>Lp.</th>
                                            <th>ID</th>
                                            <th>ID użytk.</th>
                                            <th>Aktywny</th>
                                            <th>Imię</th>
                                            <th>Nazwisko</th>
                                            <th>Nr. tel.</th>
                                            <th>NTRP</th>
                                            <th>Runda</th>
                                            <th>Grupa</th>
                                            <th>Wygr. mecze</th>
                                            <th>Przegr. mecze</th>
                                            <th>Wygr. sety</th>
                                            <th>Ilość punktów</th>
                                            <th>Akcje</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${allsinglesplayers}" var="player" varStatus="stat">
                                        <tr>
                                            <td>${stat.count}</td>
                                            <td>${player.id}</td>
                                            <td>${player.user.id}</td>
                                            <c:choose>
                                                <c:when test="${player.active}">
                                                    <td><i class="fas fa-check"></i></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><i class="fas fa-minus"></i></td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>${player.firstName}</td>
                                            <td>${player.lastName}</td>
                                            <td>${player.phoneNumber}</td>
                                            <td>${player.ntrp}</td>
                                            <td>${player.round.name}</td>
                                            <td>${player.group.name}</td>
                                            <td>${player.totalMatchesWon}</td>
                                            <td>${player.totalMatchesLost}</td>
                                            <td>${player.totalSetsWon}</td>
                                            <td>${player.totalPoints}</td>
                                            <td>
                                                <c:url value="/admin/singlesplayers/delete" var="deleteURL">
                                                    <c:param name="id" value="${player.id}"/>
                                                </c:url>
                                                <c:url value="/admin/singlesplayers/edit" var="updateURL">
                                                    <c:param name="id" value="${player.id}"/>
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
                <!-- Singles players tableEND -->
                <!-- Additional information-->
                <div class="columns">
                    <div class="column is-6">
                        <div class="card events-card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    Informacje dotyczące zawodników:
                                </p>
                            </header>
                            <div class="card-table">
                                <tr>
                                    <ul>
                                        <li>Zawodnik jest aktywny (<i class="fas fa-check"></i>), gdy uzupełnił swój profil (ale niekoniecznie dopisał się do rundy)</li>
                                        <li>Zawodnik jest nieaktywny (<i class="fas fa-minus"></i>), gdy w trakcie trwania rundy postanowił się z niej wycofać. Usunięcie takiego zawodnika może nastąpić dopiero po zakończeniu rundy</li>
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

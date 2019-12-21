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
<section class="hero is-fullheight">
    <!--.hero-head-->
    <div class="hero-head">
        <div class="columns is-mobile is-marginless heading has-text-weight-bold">
            <div class="column left">
                <p class="navbar-item is-size-3 has-text-grey-light">ZARZĄDZANIE MECZAMI</p>
                <!-- ... -->
            </div>
            <div class="column center desktop">
                <a class="navbar-item has-text-black is-size-5" href="/admin/matches/add">DODAJ MECZ</a>
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
                    <td>ID meczu</td>
                    <td>Grupa</td>
                    <td>Data meczu</td>
                    <td>Zawodnik 1</td>
                    <td>Liczba wygranych setów</td>
                    <td>Zawodnik 2</td>
                    <td>Liczba wygranych setów</td>
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
            </table>
        </div>
    </header>
</section>






</body>
</html>

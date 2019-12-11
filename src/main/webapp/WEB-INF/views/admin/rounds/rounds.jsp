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
                    <td>Akcje</td>
                </tr>
                <c:forEach items="${allrounds}" var="round" varStatus="stat">
                    <tr>
                        <td>${stat.count}</td>
                       <td>${round.id}</td>
                       <td>${round.name}</td>
                       <td>${round.startDate}</td>
                       <td>${round.endDate}</td>
                        <td>
                            <c:url value="/" var="deleteURL">
                                <c:param name="id" value="${round.id}"/>
                            </c:url>
                            <c:url value="/" var="updateURL">
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

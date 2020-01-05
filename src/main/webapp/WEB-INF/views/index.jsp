<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 09/12/2019
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Wrocławska Liga Tenisowa</title>
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
    <style>
        .hero {
            background: url(public_html/images/tenis.jpeg) center / cover;
        }

        @media (max-width: 1024px) {.hero {background: url(public_html/images/tenis.jpeg) center / cover;}}
    </style>
</head>

<body>
<!--. hero -->
<section class="hero is-fullheight">
    <!--.hero-head-->
    <div class="hero-head">
        <div class="columns is-mobile is-marginless heading has-text-weight-bold">
            <div class="column left">
                <p class="navbar-item is-size-3 has-text-grey-light">WROCŁAWSKA LIGA TENISOWA</p>
                <!-- ... -->
            </div>
            <div class="column center desktop">
                <p class="navbar-item has-text-black is-size-5">O LIDZE</p>
                <a class="navbar-item has-text-black is-size-5" href="/ranking">WYNIKI</a>
                <p class="navbar-item has-text-black is-size-5">ZASADY</p>
                <!-- ... -->
            </div>
            <div class="column right">
                <sec:authorize access="!isAuthenticated()">
                    <a class="navbar-item desktop has-text-black is-size-5" href="/register">REJESTRACJA</a>
                    <a class="navbar-item desktop has-text-black is-size-5" href="/login">ZALOGUJ</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasAnyRole('USER')">
                        <a class="navbar-item desktop has-text-black is-size-5" href="/user">MOJE KONTO</a>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('ADMIN')">
                        <a class="navbar-item desktop has-text-black is-size-5" href="/admin">KONTO ADMINA</a>
                    </sec:authorize>
                    <form method="post" action="/logout">
                        <button class="navbar-item desktop has-text-black is-size-5" type="submit">WYLOGUJ</button>
                        <sec:csrfInput/>
                    </form>
                </sec:authorize>
                <!-- ... -->
            </div>
        </div>
    </div>
    <!-- /. hero-head-->
    <!-- .hero-body-->
    <header class="hero-body">
        <div class="is-overlay has-text-centered single-spaced" style="top: 250px;">

            <h1 class="subtitle is-2 has-text-black has-text-weight-bold">NOWA AMATORSKA LIGA TENISOWA WE WROCŁAWIU</h1></br>
            <h2 class="title is-4">DOŁĄCZ JUŻ DZIŚ! NOWA RUNDA STARTUJE OD KWIETNIA 2020!</h2>
        </div>
        <div class="column center">
            <sec:authorize access="!isAuthenticated()">
                <a class="button is-danger is-inverted is-rounded is-outlined has-text-weight-bold" href="/register"
                   style="width: 10%; border: 0.15em solid white;">
                    Rejestracja
                </a>
                <a class="button is-danger is-inverted is-rounded is-outlined has-text-weight-bold" href="/login"
                   style="width: 10%; border: 0.15em solid white;">
                    Logowanie
                </a>
            </sec:authorize>
        </div>
    </header>
</section>
<!--/.hero -->
</body>

</body>
</html>
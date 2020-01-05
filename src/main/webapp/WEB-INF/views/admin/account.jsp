<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 10/12/2019
  Time: 21:09
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
                        <li><a href="/admin/users">Przeglądaj</a></li>
                    </ul>
                </aside>
            </div>
            <!-- Admin panel on the rightEND-->
            <!-- Admin welcome message-->
            <div class="column is-9">
                <section class="hero is-info welcome is-small">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                Witaj Administratorze!
                            </h1>
                            <h2 class="subtitle">

                            </h2>
                        </div>
                    </div>
                </section>
                <!-- Admin welcome messageEND-->
            </div>
        </div>
    </div>
</section>
</body>
</html>

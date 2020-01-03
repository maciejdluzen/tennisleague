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
                        <a class="navbar-item button" href="/"><strong>Strona główna</strong></a>
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
                        <li><a href="">Przeglądaj</a></li>
                        <li><a href="">Dodaj</a></li>
                        <li><a href="">EDYTUJ PROFIL</a></li>
                        <li><a href="">ZAPIS DO RUNDY</a></li>
                        <li><a href="">WYCOFAJ SIĘ DO RUNDY</a></li>
                        <li><a>USUŃ KONTO</a></li></br>
                        <li><a>ZGŁOŚ PROBLEM</a></li>
                    </ul>
                </aside>
            </div>
        </div>
    </div>
</section>


















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
                <a class="navbar-item has-text-black is-size-5" href="/admin/rounds">RUNDY</a>
                <a class="navbar-item has-text-black is-size-5" href="/admin/groups">GRUPY</a>
                <a class="navbar-item has-text-black is-size-5" href="/admin/matches">MECZE</a>
                <a class="navbar-item has-text-black is-size-5" href="/admin/singlesplayers">ZAWODNICY</a>
                <a class="navbar-item has-text-black is-size-5" href="/admin/users">UŻYTKOWNICY</a>
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
</section>
</body>
</html>

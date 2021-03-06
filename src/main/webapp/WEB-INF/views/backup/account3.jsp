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

<!-- this is old user account page, before creating new dashboard -->

<!DOCTYPE html>
<html>
<head>
    <title>Spring Transitions</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <link href="../../../../resources/static/public_html/styles/bulma.css" rel="stylesheet" type="text/css">
    <link href="../../../../resources/static/public_html/styles/helpers.css" rel="stylesheet" type="text/css">
    <link href="../../../../resources/static/public_html/styles/grid.css" rel="stylesheet" type="text/css">

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
                <p class="navbar-item is-size-3 has-text-grey-light">WROCŁAWSKA LIGA TENISOWA</p>
                <!-- ... -->
            </div>
            <div class="column center desktop">
                <a class="navbar-item has-text-black is-size-5" href="/user/joinround">ZAPIS DO RUNDY</a>
                <a class="navbar-item has-text-black is-size-5" href="/user/matches">MOJE MECZE</a>
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
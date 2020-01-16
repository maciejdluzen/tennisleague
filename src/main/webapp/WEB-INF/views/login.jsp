<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logowanie</title>
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
<style>
    .hero {
        background: url(public_html/images/tenis3.jpeg) center / cover;
    }

    @media (max-width: 1024px) {.hero {background: url(public_html/images/tenis3.jpeg) center / cover;}}
</style>
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
                <a class="navbar-item desktop has-text-black is-size-5" href="/register">REJESTRACJA</a>
                <a class="navbar-item desktop has-text-black is-size-5" href="/login">ZALOGUJ</a>
                <!-- ... -->
            </div>
        </div>
    </div>
    <!-- /. hero-head-->
    <!-- .hero-body-->
    <header class="hero-body">
        <div class="column center">
            <div class="box has-background-grey-lighter">
                <h2 class="subtitle is-3">Logowanie</h2>
            <form method="post" action="/login">
                <div class="field">
                    <c:if test="${param['error'] != null}">
                        <p class="help is-danger has-background-grey-light is-size-5">
                            <s:message code="pages.login.form.login-error"/>
                        </p>
                    </c:if>
                    <label class="label" for="username">Nazwa użytkownika</label>
                    <div class="control has-icons-left">
                        <input type="text" id="username" name="username" required class="input"/>
                        <span class="icon is-small is-left">
                                <i class="fas fa-user"></i>
                        </span>
                    </div>
                </div>
                <div class="field">
                    <label class="label" for="password">Hasło</label>
                    <div class="control has-icons-left">
                        <input type="password" id="password" name="password" required class="input"/>
                        <span class="icon is-small is-left">
                                <i class="fas fa-lock"></i>
                            </span>
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <button class="button is-success is-link" type="submit">Zaloguj</button>
                    </div>
                </div>
                <sec:csrfInput/>
            </form>
            </div>
        </div>
    </header>
</section>
<!--/.hero -->
</body>
</html>
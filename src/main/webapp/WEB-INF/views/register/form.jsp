<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Rejestracja</title>
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
        background: url(public_html/images/tenis4.jpeg) center / cover;
    }

    @media (max-width: 1024px) {.hero {background: url(public_html/images/tenis4.jpeg) center / cover;}}
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
            <form:form method="post" modelAttribute="registrationData">
                <div class="field">
                    <form:label path="username" cssClass="label">Nazwa użytkownika</form:label>
                    <div class="control has-icons-left">
                        <form:input path="username" cssClass="input" placeholder="Nazwa użytkownika" required="true"/>
                        <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                        <form:errors path="username" element="p" cssClass="help is-danger has-background-grey-light is-size-5"/>
                    </div>
                </div>
                <div class="field">
                    <form:label path="email" cssClass="label">Adres e-mail</form:label>
                    <div class="control has-icons-left">
                        <form:input path="email" cssClass="input" placeholder="Adres e-mail" required="true"/>
                        <span class="icon is-small is-left"><i
                                class="fas fa-envelope"></i></span>
                        <form:errors path="email" element="p" cssClass="help is-danger has-background-grey-light is-size-5"/>
                    </div>
                </div>
                <div class="field">
                    <form:label path="password" cssClass="label">Hasło</form:label>
                    <div class="control has-icons-left">
                        <form:password path="password" cssClass="input" placeholder="Hasło" required="true"/>
                        <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                        <form:errors path="password" element="p" cssClass="help is-danger has-background-grey-light is-size-5"/>
                    </div>
                </div>
                <div class="field">
                    <form:label path="rePassword" cssClass="label">Powtórz hasło</form:label>
                    <div class="control has-icons-left">
                        <form:password path="rePassword" cssClass="input" placeholder="Powtórz hasło" required="true"/>
                        <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                        <form:errors path="rePassword" element="p" cssClass="help is-danger has-background-grey-light is-size-5"/>
                    </div>
                </div>
                <div class="field">
                    <form:label path="termsAcceptance"
                                cssClass="checkbox">
                        <form:checkbox path="termsAcceptance"
                                       required="true"/> Akceptuję warunki korzystania z portalu</form:label>
                    <form:errors path="termsAcceptance" element="p" cssClass="help is-danger has-background-grey-light is-size-5"/>
                </div>
                <div class="field is-grouped">
                    <div class="control">
                        <button class="button is-success is-link" type="submit">Zarejestruj
                        </button>
                    </div>
                    <div class="control">
                        <button class="button is-text" type="reset">Wyczyść</button>
                    </div>
                </div>
                <sec:csrfInput/>
            </form:form>
        </div>
    </header>
</section>
<!--/.hero -->







</body>
</html>
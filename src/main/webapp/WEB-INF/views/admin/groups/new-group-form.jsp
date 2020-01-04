<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tworzenie nowej grupy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
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
                <section class="hero is-info">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title has-text-centered">
                                Dodawanie nowej rundy
                            </h1>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="columns">
            <div class="column is-4">

            </div>
            <div class="column is-4">
                <form:form method="post" modelAttribute="newGroup">
                    <div class="field">
                        <label class="label">Nazwa grupy</label>
                        <div class="control">
                            <form:input path="name"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Nazwa rundy</label>
                        <div class="select">
                            <form:select path="roundId" items="${allrounds}" itemLabel="name" itemValue="id"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-link" type="submit">Utwórz</button>
                        </div>
                        <div class="control">
                            <a class="button is-link is-light" href="/admin">Anuluj</a>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form:form>
            </div>
            <div class="column is-4">

            </div>
        </div>
    </div>
</section>
</body>
</html>

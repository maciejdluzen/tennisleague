<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/12/2019
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ranking</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Bulma!</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<!-- Header -->
<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main-navigation">
        <div class="navbar-brand">
            <div class="navbar-item is-size-3 has-text-grey-bold">
                <p>WROCŁAWSKA LIGA TENISOWA</p>
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
        </div>
    </nav>
</header>
<!-- HeaderEND -->
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column is-12">
                <section class="hero is-light">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title has-text-centered">
                                WROCŁAWSKA LIGA TENISOWA - RUNDA ${ranking[0].round.name}
                            </h1>
                            <h2 class="subtitle has-text-centered">
                                Start: ${ranking[0].round.startDate}
                                Koniec: ${ranking[0].round.endDate}
                            </h2>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="columns">
            <div class="column is-4 is-offset-2">
                <c:forEach items="${ranking}" var="group">
                <article class="message is-danger">
                    <div class="message-header">
                        <p>${group.name}</p>
                    </div>
                    <div class="message-body has-text-centered">
                        <tr>
                            <td>
                                <ol>
                                    <c:forEach items="${group.playersDescription}" var="playerdescription">
                                        <li>${playerdescription}</li>
                                    </c:forEach>
                                </ol>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <ul>
                                    <c:forEach items="${group.matchesDescription}" var="matchdescription">
                                        <li>${matchdescription}</li>
                                    </c:forEach>
                                </ul>
                            </td>
                        </tr>
                    </div>
                </article>
                </c:forEach>
            </div>
            <div class="column is-3">

            </div>
            <div class="column is-3">

            </div>
        </div>
    </div>
</section>



<header class="hero-body">
    <div class="column center">
        <table class="table">
            Wyniki rundy: <tr>${ranking[0].round.name}</tr>
            Rozpoczęcie rozgrywek: <tr>${ranking[0].round.startDate}</tr>
            Zakończenie rozgrywek: <tr>${ranking[0].round.endDate}</tr>
            <c:forEach items="${ranking}" var="group">
                <tr>
                    <td>${group.name}</td>
                </tr>
                <tr>
                    <td>
                        <ol>
                            <c:forEach items="${group.playersDescription}" var="playerdescription">
                                <li>${playerdescription}</li>
                            </c:forEach>
                        </ol>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <c:forEach items="${group.matchesDescription}" var="matchdescription">
                                    <li>${matchdescription}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</header>





</body>
</html>

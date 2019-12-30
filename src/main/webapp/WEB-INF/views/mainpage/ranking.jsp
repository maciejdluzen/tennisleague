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
    <link rel="stylesheet" type="text/css" href="public_html/styles/style1.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    <style>
        .hero.is-fullheight {
            background: url(public_html/images/tenis4.jpeg) center / cover;
        }

        @media (max-width: 1024px) {.hero {background: url(public_html/images/tenis4.jpeg) center / cover;}}
    </style>
</head>
<body>
<!-- Header -->
<section class="hero is-fullheight">

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
                                WROCŁAWSKA LIGA TENISOWA - ${currentRound.name}
                            </h1>
                            <h2 class="subtitle has-text-centered">
                                Start: ${currentRound.startDate}
                                Środek: ${currentRound.midpointDate}
                                Koniec: ${currentRound.endDate}
                            </h2>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="columns">
            <div class="column is-4 is-offset-2">
                <c:forEach items="${ranking}" var="group">
                <article class="message is-dark">
                    <div class="message-header">
                        <p>${group.name}</p>
                        <i class="far fa-caret-square-down hide-group"></i>
                    </div>
                    <div class="message-body group-info">
                        <tr>
                            <td>
                                <ol>
                                    <c:forEach items="${group.playersDescription}" var="playerdescription">
                                        <li>${playerdescription}</li>
                                    </c:forEach>
                                </ol>
                            </td>
                        </tr>
                        <br/>
                        <br/>
                        <tr>
                            <td>
                                <ul>
                                    <p>Rozegrane mecze: </p><br/>
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
            <div class="column is-2">

            </div>


            <div class="column is-2">
                <div class="columns is-gapless">
                    <article class="message is-warning">
                        <div class="message-header">
                            Następne rundy:
                        </div>
                        <div class="message-body">
                            <tr>
                                <td>
                                    <ul>
                                        <c:forEach items="${futureRounds}" var="round">
                                            <li>${round.name}</li>
                                            <li>Start: ${round.startDate}</li>
                                            <li>Zapisy:</li>
                                            <li>Do: ${round.joinByDate}</li>
                                        </c:forEach>
                                    </ul><br/>
                                </td>
                            </tr>
                        </div>
                    </article>
                </div>
                <div class="columns is-gapless">
                    <article class="message is-success">
                        <div class="message-header">
                            Poprzednie rundy:
                        </div>
                        <div class="message-body">
                            <tr>
                                <td>
                                    <ul>
                                        <c:forEach items="${previousRounds}" var="round">
                                            <li>${round.name}</li>
                                            <li>${round.endDate}</li>
                                            <li>Zobacz wyniki</li>
                                        </c:forEach>
                                    </ul><br/>
                                </td>
                            </tr>
                        </div>
                    </article>
                </div>
            </div>
        </div>
    </div>
</section>

</section>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script src="public_html/scripts/script.js"></script>

</body>
</html>

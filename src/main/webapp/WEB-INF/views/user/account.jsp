<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 20/12/2019
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Bulma!</title>
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
            <!-- User panel on the right-->
            <div class="column is-3 has-background-primary">
                <aside class="menu is-hidden-mobile">
                    <p class="menu-label">
                        General
                    </p>
                    <ul class="menu-list">
                        <c:choose>
                            <c:when test="${user.singlesPlayer == null}">
                                <li><a href="/user/playerdetails">UZUPEŁNIJ PROFIL</a></li></br>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/user/playerdetails/edit">EDYTUJ PROFIL</a></li></br>
                            </c:otherwise>
                        </c:choose>
                        <li><a href="/user/joinround2">ZAPIS DO RUNDY: ${soonestround.name}</a></li></br>
                        <li><a href="/user/withdraw">WYCOFAJ SIĘ DO RUNDY</a></li></br>
                        <li><a>USUŃ KONTO</a></li></br>
                        <li><a>ZGŁOŚ PROBLEM</a></li>
                    </ul>
                </aside>
            </div>
            <!-- User panel on the rightEND-->
            <!-- User welcome message-->
            <div class="column is-9">
                <section class="hero is-info welcome is-small">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                Witaj ${user.username}
                            </h1>
                            <h2 class="subtitle">
                                <c:choose>
                                    <c:when test="${user.singlesPlayer.round != null && user.singlesPlayer.active == true}">
                                        Obecnie grasz w rundzie, która kończy się ${user.singlesPlayer.round.endDate}
                                        Musisz rozegrać 3 mecze do ${user.singlesPlayer.round.midpointDate}, aby zdobyć 2 bonusowe punkty
                                    </c:when>
                                    <c:otherwise>
                                        Obecnie nie jesteś zapisany do żadnej rundy.
                                    </c:otherwise>
                                </c:choose>

                            </h2>
                        </div>
                    </div>
                </section>
                <!-- User welcome messageEND-->

                <!-- User matches-->
                <div class="column">
                    <div class="card events-card">
                        <header class="card=header">
                            <p class="card-header-title">
                                Moje mecze
                            </p>
                        </header>
                        <div class="card-table">
                            <div class="content">
                                <table class="table is-fullwidth is-striped">
                                    <tbody>
                                    <tr>
                                        <td width="5%"><i class="fas fa-baseball-ball"></i></td>
                                        <td>Lp.</td>
                                        <td>Data meczu</td>
                                        <td>Imię i nazwisko przeciwnika</td>
                                        <td>Wynik (Ja : Przeciwnik)</td>
                                        <td>Dodaj wynik</td>
                                    </tr>
                                    <c:forEach items="${userMatches}" var="match" varStatus="stat">
                                        <tr>
                                            <td width="5%"><i class="fas fa-baseball-ball"></i></td>
                                            <td>${stat.count}</td>
                                            <td>${match.dateOfGame}</td>
                                            <c:choose>
                                                <c:when test="${user.username.equals(match.playerOne.user.username)}">
                                                    <td>${match.playerTwo.firstName} ${match.playerTwo.lastName}</td>
                                                    <td>${match.playerOneSets} : ${match.playerTwoSets}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${match.playerOne.firstName} ${match.playerOne.lastName}</td>
                                                    <td>${match.playerTwoSets} : ${match.playerOneSets}</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td class="level-right">
                                                <c:choose>
                                                    <c:when test="${match.playerOneSets == 0 && match.playerTwoSets == 0}">
                                                        <c:choose>
                                                            <c:when test="${match.playerTwo.active == true && match.playerOne.active == true}">
                                                                <c:url value="/user/matches/reportresult" var="reportResultURL">
                                                                    <c:param name="id" value="${match.id}"/>
                                                                </c:url>
                                                                <a class="button is-small is-primary" href="${reportResultURL}">Dodaj wynik</a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <p>Gracz się wycofał</p>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <p>Wynik dodany</p>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- User matchesEND-->
                <!-- Group ranking-->
                <div class="columns">
                    <div class="column is-6">
                        <div class="card events-card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    <c:choose>
                                        <c:when test="${user.singlesPlayer.group != null}">
                                            Ranking Twojej grupy: ${user.singlesPlayer.group.name}
                                        </c:when>
                                        <c:otherwise>
                                            Nie jesteś jeszcze zapisany do żadnej grupy
                                        </c:otherwise>
                                    </c:choose>
                                </p>
                            </header>
                            <div class="card-table">
                                <div class="content">
                                    <table class="table is-fullwidth is-striped">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <ul>
                                                    <c:choose>
                                                        <c:when test="${user.singlesPlayer.group != null}">
                                                            <c:forEach items="${ranking.playersDescription}" var="playerDescription">
                                                                <li>${playerDescription}</li>
                                                            </c:forEach>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li></li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </ul>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Group rankingEND-->
                    <!-- All gorup matches-->
                    <div class="column is-6">
                        <div class="card events-card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    Wszystkie mecze rozegrane w grupie
                                </p>
                            </header>
                            <div class="card-table">
                                <div class="content">
                                    <table class="table is-fullwidth is-striped">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <ul>
                                                    <c:choose>
                                                        <c:when test="${ranking != null}">
                                                            <c:forEach items="${ranking.matchesDescription}" var="matchDescription">
                                                                <li>${matchDescription}</li>
                                                            </c:forEach>
                                                        </c:when>
                                                            <c:otherwise>
                                                                <li>Nie jesteś jeszcze zapisany do żadnej grupy</li>
                                                            </c:otherwise>
                                                    </c:choose>
                                                </ul>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- All group matchesEND-->
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>

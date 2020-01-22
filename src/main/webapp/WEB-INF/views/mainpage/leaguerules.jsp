<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 17/01/2020
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zasady Wrocławskiej Ligi Tenisowej</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <link rel="stylesheet" type="text/css" href="public_html/styles/style1.css">
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
        </div>
        <div class="navbar-menu">
            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="buttons">
                        <form>
                            <a class="navbar-item button" href="/" style="margin-right: 1em;"><strong>Strona główna</strong></a>
                        </form>
                        <sec:authorize access="isAuthenticated()">
                            <form method="post" action="/logout">
                                <button class="button is-primary" type="submit"><strong>Wyloguj</strong></button>
                                <sec:csrfInput/>
                            </form>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
<!-- HeaderEND -->
<section>
    <div class="container">
        <div class="columns">
            <div class="column is-12">
                <section class="hero is-light">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title has-text-centered">
                            <br/>
                                Zasady Ligi Tenisowej
                            </h1>
                            <h2>

                            </h2>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="columns">
            <div class="column is-4 is-offset-2">
                <c:forEach items="${allrules}" var="rule">
                    <ul class="is-size-4">${rule.number} ${rule.description}</ul>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script src="public_html/scripts/script.js"></script>

</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 27/12/2019
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie wycofania z rundy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Bulma!</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <div class="columns">
        </div>
        <div class="columns">
            <div class="column is-one-third is-offset-one-third">
                <article class="message is-danger">
                    <div class="message-header">
                        <p>Uwaga!</p>
                    </div>
                    <div class="message-body has-text-centered">
                        Powtwierdź chęć wycofania z obecnej rundy.
                    </div>
                </article>
                <form:form method="post" modelAttribute="singlesPlayer">
                    <p><form:hidden path="id"/></p>
                    <p><form:hidden path="userId"/></p>
                    <p><form:hidden path="roundId"/></p>
                    <p><form:hidden path="groupId"/></p>
                    <p><form:hidden path="totalMatchesLost"/></p>
                    <p><form:hidden path="totalPoints"/></p>
                    <p><form:hidden path="totalSetsWon"/></p>
                    <p><form:hidden path="totalMatchesWon"/></p>
                    <p><form:hidden path="notes"/></p>
                    <p><form:hidden path="active"/></p>
                    <p><form:hidden path="firstName"/></p>
                    <p><form:hidden path="lastName"/></p>
                    <p><form:hidden path="phoneNumber"/></p>
                    <p><form:hidden path="ntrp"/></p>
                    <div class="field is-grouped">
                        <div class="control">
                            <input class = button is-link type="submit" value="Potwierdzam">
                        </div>
                        <div class="control">
                            <a class="button is-link" href="/user">Powrót</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="columns">
        </div>
    </div>
</section>
</body>
</html>

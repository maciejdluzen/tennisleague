<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 21/12/2019
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dodaj wynik meczu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column is-12">
                <section class="hero is-info">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title has-text-centered">
                                Dodanie wyniku rozegranego meczu
                            </h1>
                            <h2 class="subtitle has-text-centered">
                                ${match.playerOneLastName} vs. ${match.playerTwoLastName}
                            </h2>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="columns">
            <div class="column is-4">

            </div>
            <div class="column is-4">
                <article class="message is-danger">
                    <div class="message-header">
                        <p>Uwaga</p>
                    </div>
                    <div class="message-body has-text-centered">
                        Przed zatwierdzeniem upewnij się, że wszystkie informacje są poprawne.</br>
                        <strong>Nie ma możliwości edycji wyników!</strong>
                    </div>
                </article>
                <div class="box has-background-grey-lighter">
            <form:form method="post" modelAttribute="match">
                <form:hidden path="id"/>
                <div class="field">
                    <label class="label">Data rozegrania meczu</label>
                    <div class="control">
                        <form:input path="dateOfGame" type="date" cssClass="input" dataType="rrrr-MM-dd"/>
                        <form:errors path="dateOfGame"/>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Nazwisko zawodnika: ${match.playerOneLastName}</label>
                    <div class="control">
                        <label class="label">Liczba wygranych setów:</label>
                        <div class="select">
                            <form:select path="playerOneSets" items="${sets}" required="true"/>
                            <form:errors path="playerOneSets"/>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Nazwisko zawodnika: ${match.playerTwoLastName}</label>
                    <div class="control">
                        <label class="label">Liczba wygranych setów:</label>
                        <div class="select">
                            <form:select path="playerTwoSets" items="${sets}" required="true"/>
                            <form:errors path="playerTwoSets"/>
                        </div>
                    </div>
                </div>

                <div class="field is-grouped">
                    <div class="control">
                        <button class="button is-link" type="submit">Dodaj</button>
                    </div>
                    <div class="control">
                        <a class="button is-link is-light" href="/user">Anuluj</a>
                    </div>
                </div>

                <sec:csrfInput/>
            </form:form>
                </div>

            </div>

            <div class="column is-4">

            </div>
        </div>
    </div>
</section>
</body>
</html>
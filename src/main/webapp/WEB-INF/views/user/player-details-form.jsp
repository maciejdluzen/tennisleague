<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 23/12/2019
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Uzupełnianie profilu gracza</title>
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
            <div class="column is-12">
                <section class="hero is-info">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title has-text-centered">
                                Uzupełnienie profilu gracza
                            </h1>
                            <h2 class="subtitle has-text-centered">
                                Podaj prawdziwe informacje o sobie, w szczególności numer telefonu - inni zawodnicy będą chcieli się skontaktować, aby ustalić datę meczu!</br>
                                W ustaleniu Twojego poziomu gry NTRP, pomogą Ci informacje obok.
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
                <form:form method="post" modelAttribute="singlesPlayerDetails">
                    <div class="field">
                        <label class="label">Imię:</label>
                        <div class="control">
                            <form:input path="firstName" cssClass="input is-primary" type="text" placeholder="Imię"/>
                            <form:errors path="firstName"/>
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Nazwisko: </label>
                        <div class="control">
                            <form:input path="lastName" cssClass="input is-primary" type="text" placeholder="Nazwisko"/>
                            <form:errors path="lastName"/>
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Numer telefonu: </label>
                        <div class="control">
                            <form:input path="phoneNumber" cssClass="input is-primary" type="text" placeholder="Numer telefonu"/>
                            <form:errors path="phoneNumber"/>
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Poziom NTRP: </label>
                        <div class="control">
                            <div class="select">
                                <form:select path="ntrp">
                                    <form:option value="-" label="--Wybierz NTRP--"/>
                                    <form:options items="${ntrplevels}"/>
                                </form:select>
                            </div>
                        </div>
                    </div>

                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-link" type="submit">Zapisz</button>
                        </div>
                        <div class="control">
                            <a class="button is-link is-light" href="/user">Anuluj</a>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form:form>
            </div>
        </div>
    </div>
</section>

</body>
</html>

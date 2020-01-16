<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 16/01/2020
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Potwierdzenie usunięcia konta</title>
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
                        <p>Potwierdzenie usunięcia konta użytkownika</p>
                    </div>
                    <div class="message-body has-text-centered">
                        Konto zostało pomyślnie usunięte
                    </div>
                </article>
                <form method="post" action="/logout">
                    <button class="button is-info" type="submit"><strong>Powrót do strony głównej</strong></button>
                    <sec:csrfInput/>
                </form>
            </div>
        </div>
        <div class="columns">
        </div>
    </div>
</section>
</body>
</html>

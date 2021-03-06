<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 16/01/2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie usunięcia konta</title>
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
                        <p>Potwierdzenie usunięcia konta użytkownika</p>
                    </div>
                    <div class="message-body has-text-centered">
                        Bardzo nam przykro, że postanawiasz opuścić Wrocławską Ligę Tenisową<i class="far fa-frown"></i><br/>
                        Jeśli kiedykolwiek chciałbyś ponownie zagrać w Lidze, to serdecznie zapraszamy!<br/>
                        Konto zostanie usunięte po potwierdzeniu oraz Twoim wylogowaniu z konta
                    </div>
                </article>
                <form method="get" action="/user">
                    <input class="button is-link is-light" type="submit" value="Jednak chcę grać dalej!">
                </form>

                <form method="post" action="/user/deleteaccount">
                    <input type="hidden" name="id" value="${user.id}">
                    <input class="button is-link" type="submit" value="Potwierdzam">
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

<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 27/12/2019
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wiadomość</title>
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
                <article class="message is-warning">
                    <div class="message-header">
                        <p>Uwaga!</p>
                    </div>
                    <div class="message-body has-text-centered">
                        Aby zapisać się do rundy, musisz uzupełnić profil użytkownika!
                    </div>
                </article>
                <div class="field is-grouped">
                    <div class="control">
                        <a class="button is-link" href="/user/playerdetails">Uzupełnij profil</a>
                    </div>
                    <div class="control">
                        <a class="button is-link is-light" href="/user">Powrót</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="columns">
        </div>
    </div>
</section>
</body>
</html>

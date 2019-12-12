<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tworzenie nowej grupy</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<section class="section">
    <div class="container">
        <div class="column"></div>
        <div class="column">
        <form:form method="post" modelAttribute="newGroup">
            <form:hidden path=""/>
            <div class="field">
            Nazwa grupy: <form:input path="name"/>
            </div>
            <div class="field">
                Nazwa rundy: <form:select path="roundId" items="${allrounds}" itemLabel="name" itemValue="id"/>
                </div>
                <div class="field">
                    <div class="control">
                        <button class="button is-text" type="submit">Utwórz grupę</button>
                    </div>
                </div>
                <form:errors/>
            </form:form>
            </div>
        </div>
    </section>
    </body>
    </html>

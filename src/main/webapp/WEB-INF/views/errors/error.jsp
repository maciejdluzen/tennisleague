<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <link href="public_html/styles/bulma.css" rel="stylesheet" type="text/css">
    <link href="public_html/styles/helpers.css" rel="stylesheet" type="text/css">
    <link href="public_html/styles/grid.css" rel="stylesheet" type="text/css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<header>
</header>
<section class="section">
    <div class="container">
        <h1 class="title is-danger">
            <strong>Ups...</strong> coś poszło nie tak :(
        </h1>
        <h2 class="subtitle is-danger">
            Gdybyś potrzebował wskazówki, to:
        </h2>
        <div class="content">
            <p><i>${exception.message}<i/></p>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="content">
                <c:if test="${stackTrace != null}">
                    <pre>${stackTrace}</pre>
                </c:if>
            </div>
        </sec:authorize>
    </div>
</section>

</body>
</html>

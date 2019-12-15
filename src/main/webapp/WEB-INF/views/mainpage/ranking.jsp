<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 12/12/2019
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wyniki Meczów</title>
</head>
<body>
<header class="hero-body">
    <div class="column center">
        <table class="table">
            Wyniki rundy: <tr>${ranking[0].round.name}</tr>
            Rozpoczęcie rozgrywek: <tr>${ranking[0].round.startDate}</tr>
            Zakończenie rozgrywek: <tr>${ranking[0].round.endDate}</tr>
            <c:forEach items="${ranking}" var="group">
                <tr>
                    <td>${group.name}</td>
                </tr>
                <tr>
                    <td>
                        <ol>
                            <c:forEach items="${group.playersDescription}" var="playerdescription">
                                <li>${playerdescription}</li>
                            </c:forEach>
                        </ol>
                    </td>
                </tr>
                <tr>
                    <td>
                        <ul>
                            <c:forEach items="${group.matchesDescription}" var="matchdescription">
                                    <li>${matchdescription}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</header>
</section>
</body>
</html>

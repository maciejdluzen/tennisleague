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
            <tr>
                <c:forEach items="${ranking}" var="group">
                    <td>${group.name}</td>
                    <td>
                        <ol>
                            <c:forEach items="${group.playersDescription}" var="playerdescription">
                                <li>${playerdescription}</li>
                            </c:forEach>
                        </ol>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </div>
</header>
</section>
</body>
</html>

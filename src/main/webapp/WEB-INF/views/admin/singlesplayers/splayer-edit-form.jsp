<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 11/12/2019
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja/Dodawanie do grupy zawodnika singlowego</title>
</head>
<body>
<form:form method="post" modelAttribute="singlesPlayer">
    <p><form:hidden path="id"/></p>
    <p>Imię: <form:input path="firstName"/><form:errors path="firstName" readonly="true"/></p>
    <p>Nazwisko: <form:input path="lastName"/><form:errors path="lastName"/></p>
    <p>Poziom NTRP: <form:input path="ntrp"/><form:errors path="ntrp"/></p>
    <p>Numer telefonu: <form:input path="phoneNumber"/><form:errors path="phoneNumber"/></p>
    <p>Liczba wygranych meczy: <form:input path="totalMatchesWon"/><form:errors path="totalMatchesWon"/></p>
    <p>Liczba przegranych meczy meczy: <form:input path="totalMatchesLost"/><form:errors path="totalMatchesLost"/></p>
    <p>Liczba wygranych setów: <form:input path="totalSetsWon"/><form:errors path="totalSetsWon"/></p>
    <p>Suma punktów: <form:input path="totalPoints"/><form:errors path="totalPoints"/></p>
    <p>Runda: <form:select path="roundId">
        <form:option value=""/>
        <form:options items="${allrounds}" itemLabel="name" itemValue="id"/></p>
    </form:select></p>
    <p>Nazwa grupy: <form:select path="groupId">
    <form:option value=""/>
    <form:options items="${allgroups}" itemLabel="name" itemValue="id"/>
    </form:select></p>
    <p>Gracz aktywny? <form:checkbox path="active"/></p>
    <p>Id użytkownika: <form:input path="userId"/></p>
    <p>Adnotacje: <form:select path="notes">
        <form:option value="" label="Wybierz adnotację"/>
        <form:options items="${notes}"/>
    </form:select></p>
    <p><input type="submit" value="Submit"></p>
</form:form>
</body>
</html>

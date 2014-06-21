<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="alert alert-danger">
    Test
</div>
<c:choose>
    <c:when test="${not empty card.id}">
        <h3>Úprva kreditnej karty</h3>
    </c:when>
    <c:otherwise>
        <h3>Nová kreditná karta</h3>
    </c:otherwise>
</c:choose>
<form:form method="POST" commandName="card" role="form" action="/">
    <form:input path="id" type="hidden"/>
    <div class="form-group">
        <label for="cardNumber">Číslo karty</label>
        <form:input path="cardNumber" type="number" cssClass="form-control" id="cardNumber" placeholder="Číslo karty" disabled="${not empty card.id? true: false}"/>
    </div>
    <div class="form-group">
        <label for="owner">Meno vlastníka</label>
        <form:input path="owner" type="text" cssClass="form-control" id="owner" placeholder="Meno vlastníka"/>
    </div>
    <div class="form-group">
        <label for="validTo">Platnosť do</label>
        <form:input path="validTo" type="date" cssClass="form-control" id="validTo" placeholder="Platnosť do"/>
    </div>
    <div class="form-group">
        <label for="provider">Poskytovateľ</label>
        <form:select path="provider" id="provider" class="form-control">
            <form:options items="${providers}"/>
        </form:select>
    </div>
    <button type="submit" class="btn btn-primary">${not empty card.id?"Upraviť":"Vytvoriť"} kartu</button>
</form:form>
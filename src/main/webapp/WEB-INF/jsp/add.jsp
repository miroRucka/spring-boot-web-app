<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:if test="${error}">
    <div class="alert alert-danger">
        Nastala systémova chyba!
    </div>
</c:if>
<c:choose>
    <c:when test="${not empty card.id}">
        <h3>Úprva kreditnej karty</h3>
    </c:when>
    <c:otherwise>
        <h3>Nová kreditná karta</h3>
    </c:otherwise>
</c:choose>
<form:form method="POST" commandName="card" role="form" action="/" accept-charset="UTF-8">
    <form:input path="id" type="hidden"/>
    <c:set var="cardNumberErrors"><form:errors path="cardNumber" cssclass="error"></form:errors></c:set>
    <div class="form-group ${not empty cardNumberErrors ? 'has-error has-feedback' : ''}">
        <label for="cardNumber">Číslo karty</label>
        <form:input path="cardNumber" type="number" cssClass="form-control" id="cardNumber" placeholder="Číslo karty" readonly="${not empty card.id? true: false}" required="true"/>
        <form:errors path="cardNumber" cssclass="error"><div class="alert card alert-danger">Chybné číslo karty</div></form:errors>
    </div>
    <c:set var="ownerErrors"><form:errors path="owner" cssclass="error"></form:errors></c:set>
    <div class="form-group ${not empty validToErrors ? 'has-error has-feedback' : ''}">
        <label for="owner">Meno vlastníka</label>
        <form:input path="owner" type="text" cssClass="form-control" id="owner" placeholder="Meno vlastníka" required="true"/>
        <form:errors path="owner" cssclass="error"><div class="alert card alert-danger">Chybný vlastník</div></form:errors>
    </div>
    <c:set var="validToErrors"> <form:errors path="validTo" cssclass="error"></form:errors></c:set>
    <div class="form-group ${not empty validToErrors ? 'has-error has-feedback' : ''}">
        <label for="validTo">Platnosť do (dd.MM.yyyy)</label>
        <form:input path="validTo" type="text" cssClass="form-control" id="validTo" placeholder="Platnosť do (dd.MM.yyyy)" required="true"/>
        <form:errors path="validTo" cssclass="error"><div class="alert card alert-danger">Chybná platnosť do, zadajte v tvare dd.MM.yyyy</div></form:errors>
    </div>
    <div class="form-group">
        <label for="provider">Poskytovateľ</label>
        <form:select path="provider" id="provider" class="form-control" required="true">
            <form:options items="${providers}"/>
        </form:select>
    </div>
    <button type="submit" class="btn btn-primary">${not empty card.id?"Upraviť":"Vytvoriť"} kartu</button>
</form:form>
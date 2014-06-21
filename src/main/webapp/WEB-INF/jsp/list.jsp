<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>#</th>
        <th>Číslo karty</th>
        <th>Poskytovateľ</th>
        <th>Platnosť</th>
        <th>Vlastník</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cards}" var="card" varStatus="status">
        <tr>
            <td><c:out value="${status.index}"/></td>
            <td><c:out value="${card.cardNumber}"/></td>
            <td><c:out value="${card.provider}"/></td>
            <td><fmt:formatDate value="${card.validTo}" type="date" pattern="dd.MM.yyyy"/></td>
            <td><c:out value="${card.owner}"/></td>
            <td class="card center">
                <a href="/update/${card.id}"><span class="label label-warning">Editovať</span></a>
            </td>
            <td class="card center">
                <a href="/delete/${card.id}"><span class="label label-danger">Zmazať</span></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
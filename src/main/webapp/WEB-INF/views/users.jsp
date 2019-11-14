<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 04.11.19
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Zarządzanie Użytkownikami</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<H1>PANEL ZARZĄDZANIA UŻYTKOWNIKAMI</H1>
<div>
    <table>
        <tr>
            <td>email</td>
            <td>Imię</td>
            <td>Nazwisko</td>
            <td>Edytuj</td>
            <td>Usuń</td>
        </tr>
        <c:forEach var="user" items="${users}">
            <form type="get" action="/admin/editUsers">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <input type="hidden" value="${user.email}" name="username">
                    <td><input type="submit" value="Edytuj"></td>
                    <td><a type="button" href="/admin/deleteUser/${user.id}">Usuń</a> </td>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

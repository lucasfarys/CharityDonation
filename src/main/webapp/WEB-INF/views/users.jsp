<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="/" var="mainUrl"/>
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
<section class="login-page">
<H1 id="form">PANEL ZARZĄDZANIA UŻYTKOWNIKAMI</H1>
<div>
    <table border="1">
        <tr>
            <td>email</td>
            <td>Imię</td>
            <td>Nazwisko</td>
            <td>Edytuj</td>
            <td>Usuń</td>
        </tr>
        <c:forEach var="user" items="${users}">
            <form type="get" action="${mainUrl}admin/editUsers#form">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <input type="hidden" value="${user.email}" name="username">
                    <td><input type="submit" class="btn btn--without-border" value="Edytuj"></td>
                    <td><a href="/admin/deleteUser/${user.id}" class="btn btn--without-border">Usuń</a> </td>
                </tr>
            </form>
        </c:forEach>
    </table>
    <a href="${mainUrl}admin#form" class="btn btn--without-border">Wstecz</a>

</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>

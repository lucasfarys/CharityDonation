<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Zarządzanie Adminami</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<section class="login-page">
    <H1 id="form">PANEL ZARZĄDZANIA ADMINISTRATORAMI</H1>
    <div>
        <table border="1">
            <tr>
                <td>email</td>
                <td>Imię</td>
                <td>Nazwisko</td>
                <td>Edytuj</td>
                <td>Usuń</td>
            </tr>
            <c:forEach var="admin" items="${admins}">
                <form type="get" action="/admin/editAdmin">
                    <tr>
                        <td>${admin.email}</td>
                        <td>${admin.name}</td>
                        <td>${admin.surname}</td>
                        <input type="hidden" value="${admin.email}" name="username">
                        <td><input type="submit" value="Edytuj" class="btn btn--without-border"></td>
                        <td><a href="/admin/deleteUser/${admin.email}" class="btn btn--without-border">Usuń</a> </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
            <a href="/admin/newAdmin#form" class="btn btn--without-border">Nowy Admin</a>
            <a href="/admin#form" class="btn btn--without-border">Wstecz</a>

    </div>
</section>
    <jsp:include page="footer.jsp"/>
</body>
</html>

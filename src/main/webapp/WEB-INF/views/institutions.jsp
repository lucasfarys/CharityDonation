<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainUrl"/>

<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 03.11.19
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Zarządzanie Instytucjami</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <section class="login-page">
        <h1 id="form">Lista instytucji</h1>
        <div>
            <table border="1">
                <tr>
                    <td>Nazwa Instytucji</td>
                    <td>Edycja</td>
                    <td>Usuń</td>
                </tr>
                <c:forEach var="institution" items="${institutions}">
                    <tr>
                        <td>${institution.name}</td>
                        <td><a href="/admin/editInstitution/${institution.id}#form" class="btn btn--without-border">Edycja</a></td>
                        <td><a href="/admin/deleteInstitution/${institution.id}#form" class="btn btn--without-border">Usuń</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div><br>
        <div>
            <a href="/admin#form" class="btn btn--without-border">Wstecz</a>
            <a href="${mainUrl}admin/createInstitution#form" class="btn btn--without-border">Dodaj nową Instytucję</a>
        </div>
    </section>
    <jsp:include page="footer.jsp"/>
</body>
</html>

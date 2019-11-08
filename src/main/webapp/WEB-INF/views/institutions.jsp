<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div>
        <H1>List instytucji</H1>
    </div>
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
                    <td><a type="button" href="/admin/editInstitution/${institution.id}"/>Edycja</td>
                    <td><a type="button" href="/admin/deleteInstitution/${institution.id}"/>Usuń</td>
                </tr>
            </c:forEach>
        </table>
    </div><br>
    <a type="button" href="/admin/createInstitution">Dodaj nową instytucję</a>
    <jsp:include page="footer.jsp"/>
</body>
</html>

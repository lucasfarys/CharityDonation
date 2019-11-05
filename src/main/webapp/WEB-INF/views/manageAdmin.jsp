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
    <H1>PANEL ZARZĄDZANIA ADMINISTRATORAMI</H1>
    <div>
        <table>
            <tr>
                <td>email</td>
                <td>Imię</td>
                <td>Nazwisko</td>
                <td>Edytuj</td>
                <td>Usuń</td>
            </tr>
            <c:forEach var="admin" items="${admins}">
                <tr>
                    <td>${admin.email}</td>
                    <td>${admin.name}</td>
                    <td>${admin.surname}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>

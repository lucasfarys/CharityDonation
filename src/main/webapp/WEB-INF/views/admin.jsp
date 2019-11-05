<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 03.11.19
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Admin Panel</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <h1>Panel Administratora</h1>
    <div>
        <table>
            <tr>
                <td><a type="button" href="/admin/institution">Zarządzanie Instytucjami</a> </td>
                <td><a type="button" href="/admin/admins">Zarządzanie Adminami</a> </td>
            </tr>
        </table>
    </div>
</body>
    <jsp:include page="footer.jsp"/>
</html>

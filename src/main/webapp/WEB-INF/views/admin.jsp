<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/" var="mainUrl"/>
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
    <section class="login-page">
    <h1 id="form">Panel Administratora</h1>
        <div class="form-group form-group--buttons">
            <a href="${mainUrl}admin/institution#form" class="btn btn--without-border">Zarządzanie Instytucjami</a>
            <a href="${mainUrl}admin/admins#form" class="btn btn--without-border">Zarządzanie Adminami</a>
            <a href="${mainUrl}admin/users#form" class="btn btn--without-border">Zarządzanie Użytkownikami</a>
        </div>
    </section>
</body>
    <jsp:include page="footer.jsp"/>
</html>

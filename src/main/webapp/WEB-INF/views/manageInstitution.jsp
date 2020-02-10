<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 03.11.19
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Tworzenie/Edycja Instytucji</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<section class="login-page">
<form:form method="post" modelAttribute="institution">
<div id="editInstitution">
        <h1 id="form">Tworzenie / Edycja Instytucji</h1>
        <div class="form-group">
            <form:input path="name" type="text" placeholder="Nazwa instytucji" id="name" />
            <p><form:errors path="name"/></p>
        </div>
        <div class="form-group">
            <form:input path="description" type="text" placeholder="Opis" />
            <p><form:errors path="description"/></p>
        </div>
    <div class="form-group form-group--checkbox">
        <label>
            <form:radiobutton path="trusted" value="true" id="trusted"/>
            <span class="checkbox radio"></span>
            <span class="description">
                  <div class="title">Instytucja zaufana</div>
                </span>
        </label><br>
    </div>
        <form:input path="id" type="hidden" id="id" value="${institution.id}"/>
        <input type="submit" class="btn btn--without-border" value="Zapisz zmiany">
        <a href="/admin/institution#form" class="btn btn--without-border">Wstecz</a>
    </div>
</form:form>
</section>
</body>
    <jsp:include page="footer.jsp"/>
</html>

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
<form:form method="post" modelAttribute="institution">
    <div id="editInstitution">
        <div class="form-group">
            <form:input path="name" type="text" placeholder="Nazwa instytucji" id="name" />
            <p><form:errors path="name"/></p>
        </div>
        <div class="form-group">
            <form:input path="description" type="text" placeholder="Opis" />
            <p><form:errors path="description"/></p>
        </div>
        <div class="form-group">
            <form:radiobutton path="trusted" id="trusted" label="Zaufana Instytucja" value="true"/>
            <p><form:errors path="trusted"/></p>
        </div>
        <form:input path="id" type="hidden" id="id" value="${institution.id}"/>
        <p><input type="submit" value="Zapisz zmiany"></p>
    </div>
</form:form>
</body>
    <jsp:include page="footer.jsp"/>
</html>

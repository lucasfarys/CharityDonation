<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainUrl"/>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<section class="login-page">
    <h2 id="form">Załóż konto</h2>
    <form:form modelAttribute="user" method="post">
        <div class="form-group">
            <form:input path="email" type="email" name="email" placeholder="Email"/>
            <p><form:errors path="email"/></p>
        </div>
        <div class="form-group">
            <form:input path="name" type="text" name="name" placeholder="Name" />
            <p><form:errors path="name"/></p>
        </div>
        <div class="form-group">
            <form:input path="surname" type="text" name="surname" placeholder="Surname" />
            <p><form:errors path="surname"/></p>
        </div>
        <div class="form-group">
            <form:input path="password" type="password" name="password" placeholder="Hasło" />
            <h3><p><form:errors path="password"/></p></h3>
        </div>
        <div class="form-group">
            <form:input path="rePassword" type="password" name="password2" placeholder="Powtórz hasło" />
            <h3><p><form:errors path="rePassword"/></p></h3>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Załóż konto</button>
            <a href="${mainUrl}login#form" class="btn btn--without-border">Zaloguj się</a>
        </div>
    </form:form>
</section>


<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

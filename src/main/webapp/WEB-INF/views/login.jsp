<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <h2 id="form">Zaloguj się</h2>
    <form method="post" action="/login#form">
        <sec:csrfInput/>
        <div class="form-group">
            <input type="email" name="email" id="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <input type="password" name="password" id="password" placeholder="Hasło" />
            <a href="${mainUrl}user/resetPassword#form" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zaloguj się</button>
            <a href="${mainUrl}register#form" class="btn btn--without-border">Załóż konto</a>
        </div>
    </form>
</section>


<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

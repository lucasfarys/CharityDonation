<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 13.11.19
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resetowanie hasła</title>
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <sec:csrfInput/>
</head>
<body>
    <section class="login-page">
        <form method="post" action="/user/resetPassword">
            <sec:csrfInput/>
            <div class="form-group">
                <H2 id="form"> Podaj email</H2>
                <input type="email" name="email" id="email" placeholder="Email" />
                <input type="submit" value="Wyślij">
            </div>
        </form>
        <div class="form-group">
            <h3>${message}</h3>
        </div>
    </section>
</body>
    <jsp:include page="footer.jsp"/>
</html>

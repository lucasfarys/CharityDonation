<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 20.11.2019
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowe hasło</title>
    <jsp:include page="header.jsp"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>

</head>
<body>
    <form action="/user/newPassword" method="post">
        <sec:csrfInput/>
        <label>Podaj nowe hasło</label>
        <input type="password" name="password" placeholder="hasło">
        <input type="password" name="rePassword" placeholder="Powtórz hasło">
        <input type="hidden" value="${uuid}" name="uuid">
        <input type="submit" value="Zmień hasło">
        <label><h3>${message}</h3></label>
    </form>

    <jsp:include page="footer.jsp"/>
</body>
</html>

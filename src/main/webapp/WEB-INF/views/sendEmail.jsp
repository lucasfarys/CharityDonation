<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 10.11.19
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Wyślij email</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<form action="/sendEmail" method="post">
    <div>
        <h1>Wyślij email</h1>
        <select name="selectedUser">
            <c:forEach items="${users}" var="user">
                <option value="${user.email}">
                    ${user.email}
                </option>
            </c:forEach>
        </select><br>
        <label type="text">Temat maila</label><br>
        <input type="text" name="subject"><br>
        <label type="text">Wiadomość</label><br>
        <input type="text" name="message"rows="5"/><br>
        <sec:csrfInput/>
        <input type="submit" value="Wyślij">
    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>

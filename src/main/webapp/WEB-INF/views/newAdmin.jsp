<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 06.11.19
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Nadawanie uprawnień Administratora</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <H1> Nadawanie uprawnień Administratora</H1>
    <div>
        <tab>
            <tr>
                <td>email</td>
                <td>imę</td>
                <td>nazwisko</td>
                <td>Administrator</td>
            </tr>
            <form  method="post" action="/admin/newAdmin">
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td><input type="checkbox" name="adminList" value="${user.id}"></td>
                </tr>
            </c:forEach>
                <sec:csrfInput/>
                <input type="submit" value="Zapisz">
            </form>
        </tab>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>

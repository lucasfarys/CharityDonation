<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 22.12.2019
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moje dary</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form:form modelAttribute="editUserDTO" method="post">
    <div>
        <table>
            <tr>
                <td>Imię</td>
                <td>Nazwisko</td>
                <td>Nowe Hasło</td>
                <td>Powtórz hasło</td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td>Active</td>
                </sec:authorize>
            </tr>
            <tr>
                <td><form:input type="text" path="name" id="name" value="${user.name}"/></td>
                <td><form:input type="text" path="surname" value="${user.surname}"/></td>
                <td><form:input type="password" path="newPassword" value="........"/></td>
                <td><form:input type="password" path="reNewPassword" value="........" onfocus=""/></td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td><form:checkbox path="active"/></td>
                </sec:authorize>
                <td><input type="submit" class="btn btn--small btn--without-border" value="Zapisz zmiany"></td>
            </tr>
            <tr>
                <form:errors path="name"/>
                <form:errors path="surname"/>
                <form:errors path="newPassword"/>
                <form:errors path="reNewPassword"/>
            </tr>
        </table>
        <form:input path="email" type="hidden" value="${user.email}"/>
        <form:input path="id" type="hidden" value="${user.id}"/>
    </div>
</form:form>
</body>
<jsp:include page="footer.jsp"/>
</html>

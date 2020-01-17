<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 04.11.19
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Edycja Profilu</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <section class="login-page">
    <h1 id="form">Edycja użytkownika</h1>
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
                </tr>
                <tr>
                    <form:errors path="name"/>
                    <form:errors path="surname"/>
                    <form:errors path="newPassword"/>
                    <form:errors path="reNewPassword"/>
                </tr>
            </table>
            <input type="submit" class="btn btn--without-border" value="Zapisz zmiany">
            <a href="${mainUrl}users#form" class="btn btn--without-border">Wstecz</a>

            <form:input path="email" type="hidden" value="${user.email}"/>
            <form:input path="id" type="hidden" value="${user.id}"/>
        </div>
    </form:form>
    </section>
</body>
    <jsp:include page="footer.jsp"/>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 06.11.19
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Edycja Administratora</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <H1>Edycja Tworzenie Admina</H1>
        <div>
            <table>
                <tr>
                    <td>email</td>
                    <td>Imię</td>
                    <td>Nazwisko</td>
                    <td>Edytuj</td>
                    <td>Usuń</td>
                </tr>
                    <form:form type="post" modelAttribute="admin">
                        <tr>
                            <td>
                                <form:input path="email" placeholder="${admin.email}"/>
                                <form:errors path="email"/>
                            </td>
                            <td>
                                <form:input path="name" placeholder="${admin.name}"/>
                                <form:errors path="name"/>
                            </td>
                            <td>
                                <form:input path="surname" placeholder="${admin.surname}"/>
                                <form:errors path="surname"/>
                            </td>
                            <form:input path="id" value="${admin.id}" type="hidden"/>
                            <td><input type="submit" value="Zapisz"></td>
                        </tr>
                    </form:form>
            </table>
        </div>


    <jsp:include page="footer.jsp"/>
</body>
</html>

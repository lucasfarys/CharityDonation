<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/" var="mainUrl"/>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 19.01.2020
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Szczegóły daru</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <section class="login-page">
        <h1 id="form">Szczegóły daru</h1>
        <div>
            <table border="1">
                <tr>
                    <td>Obdarowana instytucja</td>
                    <td>Ilość przekazanych darów</td>
                    <td>Miasto</td>
                    <td>Numer telefonu</td>
                    <td>Opis</td>
                </tr>
                    <tr>
                        <td>${myDonation.institution.name}</td>
                        <td>${myDonation.quantity}</td>
                        <td>${myDonation.city}</td>
                        <td>${myDonation.phoneNumber}</td>
                        <td>${myDonation.pickUpComment}</td>
                    </tr>
            </table>
        </div><br>
        <div>
            <a href="${mainUrl}user/myDonation#form" class="btn btn--without-border">Wstecz</a>
        </div>


    </section>
</body>
    <jsp:include page="footer.jsp"/>
</html>

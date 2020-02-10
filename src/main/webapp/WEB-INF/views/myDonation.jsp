<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="mainUrl"/>
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
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
    <title>Moje dary</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<section class="login-page">
    <h1 id="form" id="form">Moje dary</h1>
        <div>
            <table border="1">
                <tr>
                    <td>Nazwa obdarowanej instytucji </td>
                    <td>Data odebrania</td>
                    <td>Szczegóły</td>
                </tr>
                <c:forEach var="myDonation" items="${myDonations}">
                    <form>
                        <sec:csrfInput/>
                        <tr>
                            <td>${myDonation.institution.name}</td>
                            <td>${myDonation.pickUpDate}</td>
                            <td><a href="${mainUrl}user/myDonationDetails?id=${myDonation.id}#form" class="btn btn--without-border" type="submit">Szczegóły</a></td>
                        </tr>
                    </form>
                </c:forEach>
            </table>
        </div><br>
        <div>
            <a href="${mainUrl}" class="btn btn--without-border">Wstecz</a>
        </div>
</section>
</body>
<jsp:include page="footer.jsp"/>
</html>

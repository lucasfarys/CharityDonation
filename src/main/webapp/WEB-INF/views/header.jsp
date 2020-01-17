<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/" var="mainUrl"/>

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="${mainUrl}login#form" class="btn btn--small btn--without-border"><spring:message code="lang.login" text="default"/></a></li>
            <li><a href="${mainUrl}user/myDonation" class="btn btn--small btn--without-border"><spring:message code="lang.myDonation" text="default"/></a></li>
            <li><a href="${mainUrl}user/editUser" class="btn btn--small btn--without-border"><spring:message code="lang.edit" text="default"/></a></li>
            <li><a href="${mainUrl}register#form" class="btn btn--small btn--highlighted"><spring:message code="lang.register" text="default"/></a></li>
            <li><a href="${mainUrl}#contact" class="btn btn--small btn--highlighted"><spring:message code="lang.sendEmail" text="default"/></a></li>
            <li>
                <select id="locale">
                    <option value=""><spring:message code="lang.change" text="default"/> </option>
                    <option value="pl"><spring:message code="lang.pl" text="default"/> </option>
                    <option value="eng"><spring:message code="lang.eng" text="default"/> </option>
                    <option value="fr"><spring:message code="lang.fr" text="default"/> </option>
                </select>
            </li>
        </ul>


        <ul>
            <li><a href="${mainUrl}" class="btn btn--without-border active"><spring:message code="lang.start" text="default"/></a></li>
            <li><a href="#work" class="btn btn--without-border"><spring:message code="lang.work" text="default"/></a></li>
            <li><a href="#aboutUs" class="btn btn--without-border"><spring:message code="lang.about" text="default"/></a></li>
            <li><a href="#fundation" class="btn btn--without-border"><spring:message code="lang.fundation" text="default"/></a></li>
<%--            <li><a href="#contact" class="btn btn--without-border"><spring:message code="lang.contact" text="default"/></a></li>--%>
        </ul>
    </nav>


    <div class="slogan container container--70" style="max-width: 50%">
        <div class="slogan--item" style="">
            <h1 style="text-align: center; margin-left: 200px">
                <spring:message code="lang.dashboardText" text="default"/>
            </h1>
        </div>
    </div>
</header>
<script src="/resources/js/language.js" type="text/javascript"/>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<%@ taglib prefix="th" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 11.11.19
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
        <h1><spring:message code="greeting" text="default"/></h1></body>

        <span><spring:message code="lang.change" text="default"/> </span>
        <select id="locales">
            <option value=""></option>
            <option value="eng"><spring:message code="lang.eng" text="default"/> </option>
            <option value="fr"><spring:message code="lang.fr" text="default"/> </option>
            <option value="pl"><spring:message code="lang.pl" text="default"/> </option>
        </select>
<script src="/resources/js/language.js" type="text/javascript"/>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</html>

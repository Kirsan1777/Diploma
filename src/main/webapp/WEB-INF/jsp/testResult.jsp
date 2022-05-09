<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09.05.2022
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/css/resultTest.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<c:if test="${picture == '1'}">
    <div class="bg-image_1">
    </div>
</c:if>
<div class="bg-image_2">
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

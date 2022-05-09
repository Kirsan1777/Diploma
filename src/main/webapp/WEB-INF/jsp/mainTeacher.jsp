<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.05.2022
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/css/teachersPage.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<span class="text_filter" style="margin-top: 15px">Java</span>
<div class="card_center">
    <div class="card_container_teacher">
        <c:forEach var="n" items="${java}">
            <div class="card_teacher">
                <img src="/images/<c:out value="${n.photoReference}"/>" width="296px" height="296px">
                <span class="card_name"><c:out value="${n.firstName}"/> <c:out value="${n.secondName}"/></span>
                <span class="card_skill"><c:out value="${n.skill}"/></span>
            </div>
        </c:forEach>
    </div>
</div>
<span class="text_filter" style="margin-top: 15px">JavaScript</span>
<div class="card_center">
    <div class="card_container_teacher">
        <c:forEach var="n" items="${javaScript}">
            <div class="card_teacher">
                <img src="/images/<c:out value="${n.photoReference}"/>" width="296px" height="296px">
                <span class="card_name"><c:out value="${n.firstName}"/> <c:out value="${n.secondName}"/></span>
                <span class="card_skill"><c:out value="${n.skill}"/></span>
            </div>
        </c:forEach>
    </div>
</div>
<span class="text_filter" style="margin-top: 15px">QA</span>
<div class="card_center">
    <div class="card_container_teacher">
        <c:forEach var="n" items="${qa}">
            <div class="card_teacher">
                <img src="/images/<c:out value="${n.photoReference}"/>" width="296px" height="296px">
                <span class="card_name"><c:out value="${n.firstName}"/> <c:out value="${n.secondName}"/></span>
                <span class="card_skill"><c:out value="${n.skill}"/></span>
            </div>
        </c:forEach>
    </div>
</div>
<span class="text_filter" style="margin-top: 15px">Design</span>
<div class="card_center">
    <div class="card_container_teacher">
        <c:forEach var="n" items="${design}">
            <div class="card_teacher">
                <img src="/images/<c:out value="${n.photoReference}"/>" width="296px" height="296px">
                <span class="card_name"><c:out value="${n.firstName}"/> <c:out value="${n.secondName}"/></span>
                <span class="card_skill"><c:out value="${n.skill}"/></span>
            </div>
        </c:forEach>
    </div>
</div>
<span class="text_filter" style="margin-top: 15px">Android</span>
<div class="card_center">
    <div class="card_container_teacher">
        <c:forEach var="n" items="${android}">
            <div class="card_teacher">
                <img src="/images/<c:out value="${n.photoReference}"/>" width="296px" height="296px">
                <span class="card_name"><c:out value="${n.firstName}"/> <c:out value="${n.secondName}"/></span>
                <span class="card_skill"><c:out value="${n.skill}"/></span>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

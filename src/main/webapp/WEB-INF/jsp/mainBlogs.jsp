<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.05.2022
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<img src="/images/PictureAnya4.png" width="1518" height="609"/>
<div>
    <div>Java</div>
    <div>JavaScript</div>
    <div>QA</div>
    <div>Design</div>
    <div>Android</div>
</div>
<div class="card_container_blog">
    <c:forEach var="n" items="${blogs}">
        <a class="card_link_blog" href="#SUCK">
            <div class="card_blog">
                <img src="/images/trend.png" width="400" height="246"/>
                <span class="card_skill"># <c:out value="${n.description}"/></span>
                <span class="card_desc"><c:out value="${n.name}"/></span>
            </div>
        </a>
    </c:forEach>
</div>
</body>
</html>

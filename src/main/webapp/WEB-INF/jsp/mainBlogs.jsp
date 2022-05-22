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
    <style>
        <%@include file="/WEB-INF/css/userBlogs.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<img src="/images/Blog.jpg" width="1518" height="609"/>
<div style="margin-top: 20px; display: flex; justify-content: center">
    <form method="get" action="/main/blogs">
        <button type="submit" class="button_find">Java</button>
    </form>
    <form method="get" action="/main/blogs_js">
        <button type="submit" class="button_find">JavaScript</button>
    </form>
    <form method="get" action="/main/blogs_qa">
        <button type="submit" class="button_find">QA</button>
    </form>
    <form method="get" action="/main/blogs_ux_ui">
        <button type="submit" class="button_find">UX/UI</button>
    </form>
    <form method="get" action="/main/blogs_android">
        <button type="submit" class="button_find">Android</button>
    </form>
</div>
<div class="card_container_blog">
    <c:forEach var="n" items="${blogs}">
        <a class="card_link_blog" href="/main/blog/${n.id}">
            <div class="card_blog">
                <img src="/images/${pictureName}" width="400" height="246"/>
                <span class="card_skill"># <c:out value="${n.description}"/></span>
                <span class="card_desc"><c:out value="${n.name}"/></span>
            </div>
        </a>
    </c:forEach>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

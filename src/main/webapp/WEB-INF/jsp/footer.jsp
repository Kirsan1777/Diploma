<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09.05.2022
  Time: 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
    <style>
        <%@include file="/WEB-INF/css/footer.css" %>
    </style>
</head>
<body>
<div class="footer" style="margin-top: 50px">
    <div class="footer_column">
        <div>
            <a href="/main/" class="logo">IT-School</a>
        </div>
        <div>
            <span class="address">ул. Программистов, д. 203</span>
        </div>
    </div>
    <div class="footer_column" style="margin-left: 460px; margin-right: 75px">
        <div>
            <a href="/main/courses" class="course_style">Курсы</a>
        </div>
        <div>
            <a href="/main/courses" class="course_style">Java developer</a>
        </div>
        <div>
            <a href="/main/courses" class="course_style">Android developer</a>
        </div>
        <div>
            <a href="/main/courses" class="course_style">QA</a>
        </div>
        <div>
            <a href="/main/courses" class="course_style">UX/UI Designer</a>
        </div>
    </div>
    <div>
        <a href="/main/teachers" style="margin-right: 10px" class="course_style">Преподаватели</a>
    </div>
    <div>
        <a href="/main/blogs" style="margin-right: 10px" class="course_style">Блог</a>
    </div>
    <div>
        <a href="/main/contacts" class="course_style">Контакты</a>
    </div>

</div>
</body>
</html>

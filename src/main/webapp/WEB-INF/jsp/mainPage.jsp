<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 27.04.2022
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/css/header.css" %>
        <%@include file="/WEB-INF/css/mainPage.css" %>
        <%@include file="/WEB-INF/css/table.css" %>
        <%@include file="/WEB-INF/css/tableTeachers.css" %>
        <%@include file="/WEB-INF/css/tableBlogs.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<img src="/images/PictureAnya1.png" width="1518" height="609"/>
<div class="string_benefits">Наши преимущества</div>
<div class="number_01">01</div>
<div class="string_01">Упор на практику</div>
<div class="number_02">02</div>
<div class="string_02">Помощь в поиске работы</div>
<div class="number_03">03</div>
<div class="string_03">Поддержка и забота</div>
<div class="number_04">04</div>
<div class="string_04">Работа на реальных проектах</div>
<div class="block_text_1">Даем структурированные знания,
    востребованные сегодня на рынке труда.
</div>
<div class="block_text_2">Помогаем составить грамотное резюме. Учим,
    как готовиться к собеседованиям и успешно их
    проходить.
</div>
<div class="block_text_3">За каждой группой закреплен опытный
    аккаунт-менеджер, который помогает в
    решении актуальных задач / вопросов по
    телефону, онлайн и лично.
</div>
<div class="block_text_4">Уже в процессе обучения ты разработаешь
    реальный проект - твой первый проект в
    профессиональном портфолио.
</div>
<div class="string_05">Ближайшие курсы</div>
<a class="link_text" href="adminCourse.jsp">Смотреть всё</a>

<div class="card_container">
    <c:forEach var="n" items="${courses}">
        <a class="card_link" href="#SUCK">
            <div class="card">
                <img class="card_image" src="/images/<c:out value="${n.photoReference}"/>" width="56" height="56"/>
                <span class="card_title"><c:out value="${n.nameCourse}"/></span>
                <span class="card_date"><c:out value="${n.startTime}"/></span>
            </div>
        </a>
    </c:forEach>
</div>
<div style="margin-top: 50px">
    <div class="string_06">Преподаватели</div>
    <a class="link_text_2" href="adminCourse.jsp">Смотреть всё</a>
</div>
<div class="card_container_teacher">
    <c:forEach var="n" items="${teachers}">
        <a class="card_link_teacher" href="#SUCK">
            <div class="card_teacher">
                <img src="/images/<c:out value="${n.photoReference}"/>" width="296px" height="296px">
                <span class="card_name"><c:out value="${n.firstName}"/> <c:out value="${n.secondName}"/></span>
                <span class="card_skill"><c:out value="${n.skill}"/></span>
            </div>
        </a>
    </c:forEach>
</div>
<div style="margin-top: 80px">
    <div class="string_06">Последнее из блога</div>
    <a class="link_text_3" href="adminCourse.jsp">Смотреть всё</a>
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

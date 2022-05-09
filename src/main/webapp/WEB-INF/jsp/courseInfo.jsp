<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.05.2022
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CourseInfo</title>
    <style>
        <%@include file="/WEB-INF/css/teachersPage.css" %>
        <%@include file="/WEB-INF/css/courseInfo.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="box_column">
    <span class="span_margin" style="margin-top: 30px; font-size: 36px">
        <c:out value="${course.nameCourse}"/>
    </span>
    <div>
        <img src="/images/PictureAnya5.png" style="position: absolute;
        left: 60.91%;
        right: 43.79%;
        top: 24.07%;
            ">
    </div>
    <span class="span_margin" style="margin-top: 25px; margin-bottom: 25px;
     font-family: 'Calibri Light', sans-serif; font-size: 25px; width: 600px">
        <c:out value="${course.description}"/>
    </span>
    <div class="box_column" style="background-color: #E3E2FF; width: 430px">
        <span class="span_margin" style="margin-top: 30px">
            Стоимость: <c:out value="${course.cost}"/> р.
        </span>
        <span class="span_margin" style="margin-top: 30px">
            Старт группы: <c:out value="${course.startTime}"/>
        </span>
        <span class="span_margin" style="margin-top: 30px">
            Дни и время занятий:
        </span>
        <span class="span_margin" style="margin-top: 5px">
            <c:out value="${course.schedule}"/>
        </span>
        <span class="span_margin" style="margin-top: 30px">
            Длительность: <c:out value="${course.continuance}"/>
        </span>`
    </div>
    <span class="span_margin" style="margin-top: 70px; font-size: 36px">
        Кем ты станешь
    </span>
    <span class="span_margin" style="margin-top: 30px; margin-bottom: 30px; width: 1100px;
            font-size: 22px; line-height: 40px">
        <c:out value="${course.text}"/>
    </span>
    <span class="span_margin" style="margin-top: 30px; font-size: 36px">
        Преподаватели курса:
    </span>
    <div class="card_center">
        <div class="card_container_teacher">
            <div class="card_teacher">
                <img src="/images/<c:out value="${teacher.photoReference}"/>" width="200px" height="200px">
                <span class="card_name"><c:out value="${teacher.firstName}"/> <c:out
                        value="${teacher.secondName}"/></span>
                <span class="card_skill"><c:out value="${teacher.skill}"/></span>
            </div>
        </div>
    </div>
</div>
<form method="post" action="/admin/claim/addNew">
    <input type="hidden" name="id" value="${course.id}">
    <div class="bg-image">
        <div>1</div>
        <div class="button_buttons">
            <input type="text" class="button_search_post" name="name" style="margin-right: 20px" placeholder="Имя"/>
            <input type="text" class="button_search_post" name="phone" style="margin-right: 20px" placeholder=" 375 (__) ___-__-__"/>
            <input type="text" class="button_search_post" name="email" placeholder="best_IT_school@it.com"/>
            <button type="submit" class="button_send" style="margin-left: 20px; padding-top: 3px">Отправить</button>
        </div>
    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>

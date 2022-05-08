<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03.05.2022
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/css/header.css" %>
        <%@include file="/WEB-INF/css/userCoursea.css" %>
        <%@include file="/WEB-INF/css/tableNewString.css"%>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="box_row" style="margin-top: 40px">
    <input type="text" class="searcher" placeholder="    Поиск"/>
    <input name="save" type="submit" class="button_find" value="Искать">
</div>

<span class="text_filter" style="margin-top: 15px">Фильтры</span>

<div class="box_row">
    <div class="box_column">
        <span>Направление</span>
        <select name="continuance" class="admin-button-stupid" id="type_of_course" aria-label="Default select example"
                style="margin-top: 10px">
            <option value="Java">Java</option>
            <option value="Java Script">Java Script</option>
            <option value="Design">Design</option>
            <option value="QA">QA</option>
            <option value="Android">Android</option>
        </select>
    </div>
    <div class="box_column">
        <span>Длительность</span>
        <select name="continuance" class="admin-button-stupid" id="continuance" aria-label="Default select example"
                style="margin-top: 10px">
            <option value="1 month">1 месяц</option>
            <option value="2 month">2 месяца</option>
            <option value="3 month">3 месяца</option>
            <option value="6 month">6 месяцев</option>
            <option value="1 year">1 год</option>
        </select>
    </div>
    <div class="box_column">
        <span>Стоимость</span>
        <select name="continuance" class="admin-button-stupid" id="price" aria-label="Default select example"
                style="margin-top: 10px">
            <option value="500">Меньше 500р</option>
            <option value="1000">Меньше 1000р</option>
            <option value="1500">Меньше 1500р</option>
            <option value="2000">Меньше 2000р</option>
        </select>
    </div>
    <div style="margin-top: 27px">
        <input name="save" type="submit" class="button_find" value="Применить">
    </div>

</div>
<div style="margin-top: 40px">
    <span class="text_type_course" >Java</span>
</div>

<div class="form_center" style="margin-top: 25px">
    <div class="card_container">
        <c:forEach var="n" items="${coursesJava}">
            <a class="card_link" href="#SUCK">
                <div class="card">
                    <img class="card_image" src="/images/<c:out value="${n.photoReference}"/>" width="56" height="56"/>
                    <span class="card_title"><c:out value="${n.nameCourse}"/></span>
                    <span class="card_date"><c:out value="${n.startTime}"/></span>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
<div style="margin-top: 40px">
<span class="text_type_course">Java Script</span>
</div>
<div class="form_center" style="margin-top: 25px">
    <div class="card_container">
        <c:forEach var="n" items="${coursesJS}">
            <a class="card_link" href="#SUCK">
                <div class="card">
                    <img class="card_image" src="/images/<c:out value="${n.photoReference}"/>" width="56" height="56"/>
                    <span class="card_title"><c:out value="${n.nameCourse}"/></span>
                    <span class="card_date"><c:out value="${n.startTime}"/></span>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
<div style="margin-top: 40px">
<span class="text_type_course">QA</span>
</div>
<div class="form_center" style="margin-top: 25px">
    <div class="card_container">
        <c:forEach var="n" items="${coursesQA}">
            <a class="card_link" href="#SUCK">
                <div class="card">
                    <img class="card_image" src="/images/<c:out value="${n.photoReference}"/>" width="56" height="56"/>
                    <span class="card_title"><c:out value="${n.nameCourse}"/></span>
                    <span class="card_date"><c:out value="${n.startTime}"/></span>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
<div style="margin-top: 40px">
<span class="text_type_course">Design</span>
</div>
<div class="form_center" style="margin-top: 25px">
    <div class="card_container">
        <c:forEach var="n" items="${coursesDesign}">
            <a class="card_link" href="#SUCK">
                <div class="card">
                    <img class="card_image" src="/images/<c:out value="${n.photoReference}"/>" width="56" height="56"/>
                    <span class="card_title"><c:out value="${n.nameCourse}"/></span>
                    <span class="card_date"><c:out value="${n.startTime}"/></span>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
<div style="margin-top: 40px">
<span class="text_type_course">Android</span>
</div>
<div class="form_center" style="margin-top: 25px">
    <div class="card_container">
        <c:forEach var="n" items="${coursesAndroid}">
            <a class="card_link" href="#SUCK">
                <div class="card">
                    <img class="card_image" src="/images/<c:out value="${n.photoReference}"/>" width="56" height="56"/>
                    <span class="card_title"><c:out value="${n.nameCourse}"/></span>
                    <span class="card_date"><c:out value="${n.startTime}"/></span>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

</body>
</html>

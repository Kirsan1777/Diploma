<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 31.03.2022
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/adminClaim.css" %>
        <%@include file="/WEB-INF/css/inputFormWithImage.css" %>
    </style>
</head>
<body>
<jsp:include page="headerAdmin.jsp"/>
<form method="POST" action="/admin/course/addNew">
    <div style="margin-right: 500px; margin-left: 500px; margin-top: 20px; margin-bottom: 30px">
        <div class="mb-3">
            <label for="nameCourse" class="form-label">Name course</label>
            <input type="text" class="form-control" id="nameCourse" name="name_course" placeholder="Java Web Develop">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" class="form-control" id="description" name="description"
                   placeholder="На этом курсе за 4 месяца вы научитесь разрабатывать приложения на языке Java">
        </div>
        <div style="margin-bottom: 10px">
            Type of course
            <select name="type" class="admin-button-stupid" aria-label="Default select example"
                    style="margin-top: 10px">
                <option value="Java">Java</option>
                <option value="JavaScript">JavaScript</option>
                <option value="QA">QA</option>
                <option value="Design">Design</option>
                <option value="Android">Android</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="cost" class="form-label">Cost</label>
            <input type="number" class="form-control" name="cost" id="cost" placeholder="1000" min="50" max="5000">
        </div>
        <div class="mb-3">
            <label for="start_time" class="form-label">Start time</label>
            <input type="date" id="start_time" name="start_time" class="form-control" placeholder="name@example.com">
        </div>
        <div class="mb-3">
            <label for="schedule" class="form-label">Schedule</label>
            <input type="text" class="form-control" id="schedule" name="schedule"
                   placeholder="Понедельник - 12.00, Вторник - 13.00">
        </div>
        <div class="mb-3">
            <label for="continuance" class="form-label">Continuance</label>
            <select name="continuance" class="admin-button-stupid" id="continuance" aria-label="Default select example"
                    style="margin-top: 10px">
                <option value="1 month">1 month</option>
                <option value="2 month">2 month</option>
                <option value="3 month">3 month</option>
                <option value="6 month">6 month</option>
                <option value="1 year">1 year</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="teacher" class="form-label">Teacher</label>
            <select name="teacher" class="admin-button-stupid" id="teacher" aria-label="Default select example"
                    style="margin-top: 10px">
                <c:forEach var="n" items="${teachers}">
                    <option value="${n.id}"><c:out value="${n.secondName}"/> <c:out value="${n.firstName}"/></option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="text" class="form-label">Text</label>
            <textarea class="form-control" name="text" id="text" rows="3"></textarea>
        </div>
        <div style="margin-top: 15px">
            <input name="save" type="submit" class="button" value="Add">
        </div>
    </div>
</form>

<div class="div-size">
    <table class="table">
        <thead class="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Cost</th>
            <th scope="col">Start time</th>
            <th scope="col">Continues</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${courses}">
            <tr style="vertical-align: middle">
                <th scope="row">
                    <img src="/images/${n.photoReference}" alt="No  image" width="60" height="60"/>
                </th>
                <td><c:out value="${n.nameCourse}"/></td>
                <td><c:out value="${n.cost}"/></td>
                <td><c:out value="${n.startTime}"/></td>
                <td><c:out value="${n.typeOfCourse}"/></td>
                <form method="post" action="/admin/course/delete/${n.id}">
                    <td style="margin-right: 5px">
                        <button type="submit" class="button-delete">Delete</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

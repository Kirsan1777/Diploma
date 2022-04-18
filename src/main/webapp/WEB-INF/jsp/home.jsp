<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 24.02.2022
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/inputFormWithImage.css" %>
        <%@include file="/WEB-INF/css/adminClaim.css" %>
    </style>
</head>
<body>
<!--
${test.getNameCourse()}

<form method="GET" action="/user/post">
    <input type="number" name="idCourse">
    <input type="submit" value="View"/>
</form>

<form method="POST" action="/user/addUser" >
    <label>Login</label>
    <input type="name" name="login">
    <label>Id</label>
    <input type="number" name="id">
    <input type="submit" value="Add"/>
</form>

<img src="/images/dark.jpg" alt="No  image" width="120" height="120"/>

<img src="/images/19002.jpg" alt="No  image" width="120" height="120"/>

<img src="/images/temp.jpg" alt="No  image" width="120" height="120"/> -->

<div>
    <img id="picture" src="picture/${books.photoReference}" width="300" height="420"/>
    <form action="/imagesUpload" enctype="multipart/form-data" method="post">
        <label class="btn-outline-success acceptButton" style="margin-bottom: 0px" >
            <input id="photo" style="display: none" class="btn-outline-success acceptButton" type="file" name="picture" accept="image/*"/>
            add photo
        </label>
        <input type="hidden" name="page" value="teacher" />
        <input class="btn-outline-success acceptButton" type="submit" value="Save"/>"/>
    </form>
</div>

<form method="POST" action="/admin/teacher/addNew">
    <div class="picture-form">
        <div class="add-picture" style="margin-top: 18px">
            <img id="picture" src="picture/${books.photoReference}" width="150" height="210" alt="No image"/>
            <label class="input" style="margin-bottom: 0px">
                <input id="photo" style="display: none; width: 150px" class="input" type="file" name="picture"
                       accept="image/*"/>
                Add
            </label>
        </div>
        <div>
            <div style="margin-top: 10px">
                First name
            </div>
            <div style="margin-top: 10px">
                <label>
                    <input type="text" class="admin-button-stupid" name="first_name">
                </label>
            </div>
            <div style="margin-top: 10px">
                Second name
            </div>
            <div style="margin-top: 10px; margin-bottom: 20px">
                <label>
                    <input type="text" class="admin-button-stupid" name="second_name">
                </label>
            </div>
            <select name="skill" class="admin-button-stupid" aria-label="Default select example"
                    style="margin-top: 10px">
                <option value="Java Developer">Java Developer</option>
                <option value="JavaScript Developer">JavaScript Developer</option>
                <option value="QA">QA</option>
                <option value="Design">Design</option>
            </select>
            <div style="margin-top: 15px">
                <input name="save" type="submit" class="button" value="Save">
            </div>
        </div>

    </div>
</form>


<div style="margin-right: 500px; margin-left: 500px">
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Name course</label>
        <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Java Web Develop">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Description</label>
        <input type="email" class="form-control" id="exampleFormControlInput1"
               placeholder="На этом курсе за 4 месяца вы научитесь разрабатывать приложения на языке Java">
    </div>
    <div style="margin-bottom: 10px">
        Type of course
        <select name="skill" class="admin-button-stupid" aria-label="Default select example"
                style="margin-top: 10px">
            <option value="Java Developer">Java</option>
            <option value="JavaScript Developer">JavaScript</option>
            <option value="QA">QA</option>
            <option value="Design">Design</option>
            <option value="Android">Android</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Cost</label>
        <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="1000" min="50" max="5000">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Start time</label>
        <input type="date" class="form-control" placeholder="name@example.com">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Schedule</label>
        <input type="email" class="form-control" id="exampleFormControlInput1"
               placeholder="Понедельник - 12.00, Вторник - 13.00">
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Continuance</label>
        <select name="сontinuance" class="admin-button-stupid" aria-label="Default select example"
                style="margin-top: 10px">
            <option value="Java Developer">1 month</option>
            <option value="JavaScript Developer">2 month</option>
            <option value="QA">3 month</option>
            <option value="Design">6 month</option>
            <option value="Android">1 year</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Text</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <div style="margin-top: 15px">
        <input name="save" type="submit" class="button" value="Add">
    </div>
</div>
<!---
<form method="POST" action="/user/addUser" >
    <label>Login</label>
    <img id="picture" src="picture/${books.photoReference}" width="300" height="420"/>
    <label class="btn-outline-success acceptButton" style="margin-bottom: 0px" >
        <input id="photo" style="display: none" class="btn-outline-success acceptButton" type="file" name="picture" accept="image/*"/>
        add photo
    </label>
    <input type="submit" value="Add"/>
</form> -->

<script>
    const fileInput = document.getElementById('photo');
    const picture = document.getElementById('picture');
    console.log(fileInput);
    fileInput.addEventListener("change", (e) => {
        const file = fileInput.files[0];
        if (!file) throw Error('file is not found');

        const reader = new FileReader();
        reader.onload = () => {
            picture.src = String(reader.result);
        };
        reader.readAsDataURL(file);
    })

    function photoRef() {
        const fileInput = document.getElementById('photo');
        const file = fileInput.files?.item(0);
        if (!file) throw Error('file is not found');

        const reader = new FileReader();
        reader.onload = () => {
            this.imageSrc = String(reader.result);
        };
        reader.readAsDataURL(file);
    }
</script>

</body>
</html>

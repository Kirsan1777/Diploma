<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07.04.2022
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/adminClaim.css" %>
        <%@include file="/WEB-INF/css/inputFormWithImage.css" %>
    </style>
</head>

<body>

<jsp:include page="headerAdmin.jsp"/>


<div class="picture-form">
    <form action="/imagesUpload" enctype="multipart/form-data" method="post">
        <div class="add-picture" style="margin-top: 18px">
            <img id="picture" src="/images/Photo (5).jpg" width="150" height="210" alt="No image"/>
            <label class="input" style="margin-bottom: 0px">
                <input id="photo" style="display: none; width: 150px" class="input" type="file"
                       name="picture"
                       accept="image/*"/>
                Add
            </label>
        </div>
    </form>
    <form method="POST" action="/admin/teacher/addNew">
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
                <option value="Android">Android</option>
            </select>
            <input name="picture" type="hidden" id="costil" value="Save">
            <div style="margin-top: 15px">
                <input name="save" type="submit" class="button" value="Save">
            </div>
        </div>
    </form>
</div>


<div class="div-size">
    <table class="table">
        <thead class="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Firs name</th>
            <th scope="col">Second name</th>
            <th scope="col">Skill</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${teachers}">

            <tr style="vertical-align: middle">
                <th scope="row">
                    <img src="/images/${n.photoReference}" alt="No  image" width="60" height="60"/>
                </th>
                <td><c:out value="${n.firstName}"/></td>
                <td><c:out value="${n.secondName}"/></td>
                <td><c:out value="${n.skill}"/></td>
                <form method="post" action="/admin/teacher/delete/${n.id}">
                    <td style="margin-right: 5px">
                        <button type="submit" class="button-delete">Delete</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script>
    const fileInput = document.getElementById('photo');
    const picture = document.getElementById('picture');
    const costil = document.getElementById('costil');



    fileInput.addEventListener("change", (e) => {
        const file = fileInput.files[0];
        if (!file) throw Error('file is not found');
        console.log(e.target.value);
        const valueString = e.target.value;
        const array = valueString.split("\\");
        const result = array[array.length - 1];
        costil.value = result;
        console.log(result);
        const reader = new FileReader();
        reader.onload = () => {
            picture.src = String(reader.result);
            console.log(picture);
            console.log(reader);
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

</html>

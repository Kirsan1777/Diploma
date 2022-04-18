<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07.04.2022
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/adminClaim.css" %>
        <%@include file="/WEB-INF/css/inputFormWithImage.css" %>
    </style>
</head>
<jsp:include page="headerAdmin.jsp" />
<form method="POST" action="/admin/blog/addNew">
<div style="margin-top: 30px">
    <div style="display: flex; justify-content: space-between; margin-right: 300px; margin-left: 300px">
        <div class="mb-3" style="margin-right: 60px">
            <label for="nameBlog" class="form-label">Name blog</label>
            <input type="text" class="form-control" id="nameBlog" required="Please input value" name="name_blog" placeholder="Design in future">
        </div>
        <div class="add-picture" style="margin-top: 18px">
            <img id="picture" src="/images/19002.jpg" width="400" height="210" alt="No image"/>
            <label class="input" style="margin-bottom: 0px" >
                <input id="photo" style="display: none; width: 150px" class="input" type="file"  name="picture" accept="image/*"/>
                Add
            </label>
        </div>
        <div style="margin-bottom: 10px">
            About
            <select name="type" class="admin-button-stupid" aria-label="Default select example"
                    style="margin-top: 10px">
                <option value="Java">Java</option>
                <option value="JavaScript">JavaScript</option>
                <option value="QA">QA</option>
                <option value="Design">Design</option>
                <option value="Android">Android</option>
                <option value="Future">Future</option>
                <option value="Machine Learning">Machine Learning</option>
                <option value="UX/UI">UX/UI</option>
            </select>
        </div>
    </div>

    <div class="mb-3" style="margin-right: 400px; margin-left: 450px; margin-top: 20px; margin-bottom: 30px">
        <label for="text" class="form-label">Text</label>
        <textarea class="form-control" required="Please input value" id="text" name="text" rows="12"></textarea>
    </div>
    <div style="margin-top: 15px; margin-left: 450px" >
        <input name="save" type="submit"  class="button" value="Save">
    </div>
</div>
</form>

<div class="div-size">
    <table class="table">
        <thead class="table-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Date add</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${blogs}">

            <tr style="vertical-align: middle">
                <th scope="row">
                    <img src="/images/${n.picture}" alt="No  image" width="60" height="60"/>
                </th>
                <td><c:out value="${n.name}"/></td>
                <td><c:out value="${n.dateAdd}"/></td>
                <form method="post" action="/admin/blog/delete/${n.id}">
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

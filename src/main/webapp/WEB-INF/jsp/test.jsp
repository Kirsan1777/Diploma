<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.03.2022
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
User was add or updated



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


<div class="picture-form"> полная форма
    <div>
        <img id="picture" src="picture/${books.photoReference}" width="300" height="420"/>
        <div>
            кнопка добавить
        </div>
    </div>
    <div>
        <div>First name</div>
        <div>Second name</div>
        <select class="form-select" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
        </select>
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

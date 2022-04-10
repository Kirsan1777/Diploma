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
</head>
<body>
<jsp:include page="headerOld.jsp"/>

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

<img src="http://localhost:8080/images/dark.jpg" alt="No  image" width="120" height="120"/>

<img src="http://localhost:8080/images/19002.jpg" alt="No  image" width="120" height="120"/>

<img src="http://localhost:8080/images/temp.jpg" alt="No  image" width="120" height="120"/>

</body>
</html>

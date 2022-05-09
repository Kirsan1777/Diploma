<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09.05.2022
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BlogInfo</title>
    <style>
        <%@include file="/WEB-INF/css/blogInfo.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<img src="/images/PictureAnya6.png" width="1518" height="609"/>
<span style="display: flex; justify-content: center; font-size: 48px; margin-top: 50px">${blog.name}</span>
<span style="display: flex; justify-content: center; font-size: 20px; margin-top: 15px; color: #6F6F6F">${blog.dateAdd}</span>
<div style="font-size: 24px; margin-left: 250px; margin-top: 50px; width: 1000px;   line-height: 40px">${text1} </div>
<div class="box_column_2" style="margin-top: 50px;  font-size: 22px; line-height: 40px">
    <img src="/images/${blog.picture}" style="display: flex; justify-content: center; margin-top: 50px"/>
</div>
<div style="font-size: 24px; margin-left: 250px; margin-top: 250px; width: 1000px;  line-height: 40px ">
    ${text2}
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

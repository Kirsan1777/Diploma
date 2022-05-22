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
    <title>Claim</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/adminClaim.css" %>
    </style>
</head>
<body>
<jsp:include page="headerAdmin.jsp"/>

<div class="div-size" style="margin-top: 20px">
    <table class="table">
        <thead class="table-light">
        <tr>
            <th scope="col">Course</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Phone number</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${claims}">

            <tr style="vertical-align: middle">
                <th scope="row">
                    <c:forEach var="k" items="${courses}">
                        <c:if test="${k.id == n.idCourse}">
                            <c:out value="${k.nameCourse}"/>
                        </c:if>
                    </c:forEach>
                </th>
                <td><c:out value="${n.name}"/></td>
                <td><c:out value="${n.email}"/></td>
                <td>+<c:out value="${n.phoneNumber}"/></td>
                <form method="GET" action="/mail/send-response-to-person">
                    <input type="hidden" name="email" value="${n.email}"/>
                    <td style="margin-right: 5px">
                        <button type="submit" class="button">Send</button>
                    </td>
                </form>
                <form method="post" action="/admin/claim/delete/${n.id}">
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

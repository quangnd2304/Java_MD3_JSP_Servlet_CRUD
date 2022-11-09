<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 09/11/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <%--  Lay listStudent tu request va hien thi    --%>
    <h2>List Students of Rikkei Academy:</h2>
    <c:forEach items="${listStudent}" var="st">
        <tr>
            <td>${st.studentId}</td>
            <td>${st.studentName}</td>
            <td>${st.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/newStudent.jsp">Create New Student</a>
</body>
</html>

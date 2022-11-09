<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 09/11/2022
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/StudentServlet" method="post">
    <table border="1">
        <tr>
            <td>Student ID</td>
            <td><input type="text" name="studentId" value="${studentUpdate.studentId}" readonly></td>
        </tr>
        <tr>
            <td>Student Name</td>
            <td><input type="text" name="studentName" value="${studentUpdate.studentName}"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="${studentUpdate.age}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update" name="action"></td>
        </tr>
    </table>
</form>
</body>
</html>

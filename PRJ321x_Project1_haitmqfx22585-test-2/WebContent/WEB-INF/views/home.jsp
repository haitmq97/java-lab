<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Home page here </h2>


<hr>
<br><br>

<a href="${pageContext.request.contextPath}/user/list">user list</a>
<br><br>

<a href="${pageContext.request.contextPath}/customer/showForm">customer form</a>

<hr>

<a href="${pageContext.request.contextPath}/user/views/page/1">user list by page</a>
</body>
</html>
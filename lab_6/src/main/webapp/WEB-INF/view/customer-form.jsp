<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="customer">
	First name: <form:input path="firstName" />
		<br>
		<br>
	Last name: <form:input path="lastName" />
		<form:errors path="lastName" />

		<br>
		<br>
	CourseCode: <form:input path="courseCode" />
		<form:errors path="courseCode" />

		<br>
		<br>
		<input type="submit" value="Submit" />


	</form:form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- add in pom.xml:
<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	The student is comfirmed: ${student.firstName} ${student.lastName}

	<br>
	<br> Country: ${student.country }

	<br>
	<br> Favorite Language: ${student.favoriteLanguage}

	<br>
	<br> Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul>

</body>
</html>


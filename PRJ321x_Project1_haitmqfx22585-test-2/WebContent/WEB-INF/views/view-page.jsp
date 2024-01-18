<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h1>User List</h1>

	<form:form action="1">
		<select id="entries" name="entries">
			<option value="5">5</option>
			<option value="10">10</option>
			<option value="15">15</option>
			<option value="20">20</option>
			<option value="all">all</option>
		</select>
		<input type="submit" value="Save"
			class="btn btn-info mt-4 col-2 d-block mx-auto" />
	</form:form>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Full Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="tempUser" items="${msg}">
			<tr>
				<td>${tempUser.id}</td>
				<td>${tempUser.fullName}</td>
				<td>${tempUser.email}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="${pageContext.request.contextPath}/user/views/page/1">1</a>
	<a href="${pageContext.request.contextPath}/user/views/page/2">2</a>
	<a href="${pageContext.request.contextPath}/user/views/page/3">3</a>

	<hr>

	<a href="${pageContext.request.contextPath}">Back to List</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save customer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<div id="wrapper" >
		<div id="header" class="py-5 d-flex justify-content-center bg-success text-white">
			<h2 >CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container" class="container d-flex flex-column justify-content-center">
		<h3 class="my-4">Save Customer</h3>

		<%-- add customer form --%>
		<form:form class=" col-8 mx-auto" action="saveCustomer" modelAttribute="customer"
			method="POST" >
			<form:hidden path="id"/>
			<table class="col-8 mx-auto">
				<tbody>
					<tr>
						<td><label class="fw-bold" for="first_name">First name:</label></td>
						<td><form:input class="mt-2 col-12" id="first_name" path="firstName" /></td>
					</tr>
					<tr>
						<td><label class="fw-bold" for="last_name">Last name:</label></td>
						<td><form:input class=" mt-2 col-12" id="last_name" path="lastName" /></td>
					</tr>
					<tr>
						<td><label class="fw-bold" for="email">Email:</label></td>
						<td><form:input class="mt-2 col-12" id="email" path="email" /></td>
					</tr>

				</tbody>
			</table>
			<input type="submit" value="Save" class="btn btn-info mt-4 col-2 d-block mx-auto" />

		</form:form>
		<p class="mt-5">
		<a  href="${pageContext.request.contextPath}/customer/list">Back to
			List</a>
		</p>
	</div>
</body>
</html>
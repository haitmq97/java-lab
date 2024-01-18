<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header"
			class="py-5 d-flex justify-content-center bg-success text-white">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div class="container">
		<h3 class="mt-5 .red">Crud Demo Application</h3>

		<%-- add customer button --%>
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false"
			class="mt-2 mb-2 btn btn-sm btn-primary" />

		<%-- customer list --%>
		<table
			class="table table-bordered table-striped border-black table-success">
			<thead>
				<tr class="table-dark">
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody class="table-group-divider">
				<!-- loop over and print customer in list -->
				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
						<%-- display the update link --%>
						<a href="${updateLink}">Update</a> | 
						<a href="${deleteLink}" onclick="if(!confirm('Are you sure you want to delete this employee?')) return false;">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css"
	rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Create New Ninja</title>
<link rel="stylesheet" href="/css/main.css">

</head>
<body>
	<h1>Enrolled Ninjas</h1>
	   
	<h2>Dojo Location: <c:out value="${dojo.name}"/></h2>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}">
			<tr>
				<td><c:out value="${ninja.firstName}"/></td>
				<td><c:out value="${ninja.lastName}"/></td>
				<td><c:out value="${ninja.age}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
			<a href="/" type="button" class="btn btn-info">Go Back</a>
</body>
</html>


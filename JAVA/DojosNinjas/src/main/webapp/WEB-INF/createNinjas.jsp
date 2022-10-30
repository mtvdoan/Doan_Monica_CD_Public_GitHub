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

<!-- change to match your file/naming structure -->
</head>
<body>
	   
	<h1>Add a New Ninja</h1>
	<div class="newNinjaContainer">
		<form:form action="/createNewNinjas" method="post" type="text"
			modelAttribute="newNinja">

			<form:label path="dojos">Dojo:</form:label>

			<form:select path="dojos">

				<c:forEach var="dojo" items="${dojos}">

					<option value="${dojo.id}"><c:out
							value="${dojo.name}"/></option>

				</c:forEach>

			</form:select>



			<input type="submit" value="Submit" />





		<div class="mb-3 row">
			<label for="firstName" class="col-sm-2 col-form-label">First
				Name</label>
			<div class="col-sm-5">
				<form:input path="firstName" type="text" class="form-control"
					id="firstName" />
			</div>
		</div>
		<div class="mb-3 row">
			<label for="lastName" class="col-sm-2 col-form-label">Last
				Name</label>
			<div class="col-sm-5">
				<form:input path="lastName" type="text" class="form-control"
					id="lastName" />
			</div>
		</div>
		<div class="mb-3 row">
			<label for="age" class="col-sm-2 col-form-label">Age</label>
			<div class="col-sm-5">
				<form:input path="age" type="number" class="form-control" min="0"
					id="age" />
			</div>
		</div>
		<button class=" col-sm-3 btn btn-success">Create</button>
		</form:form>
		<a href="/" type="button" class="btn btn-info">Go Back</a>

	</div>

</body>
</html>


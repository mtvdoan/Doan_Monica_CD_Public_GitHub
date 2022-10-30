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
<title>Create a New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<h1>New Dojo</h1>
	<form:form action="/createNewDojos" method="post" type="text" modelAttribute="newDojo">
	<form:hidden path="id"/>
		<div class="mb-3 row">
			<label for="newDojo" class="col-sm-2 col-form-label">New Dojo Name</label>
			<div class="col-sm-5">
				<form:input path="name" type="text" class="form-control" id="newDojo"></form:input>
			</div>
			<button class=" col-sm-3 btn btn-success" type="submit">Create</button>
		</div>
	</form:form>
	<a href="/" type="button" class="btn btn-info">Go Back</a>
</body>
</html>


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
<title>Dojos Ninjas Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<!-- change to match your file/naming structure -->

<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	   

	<h1>Welcome Dojos and Ninjas</h1>
	<div class="homeButtons">
		<p>
			<a href="/createDojos" type="button" class="btn btn-primary">Create
				a Dojo</a> 
			<a href="/createNinjas" type="button" class="btn btn-success">Add
				a New Ninja</a>
		</p>
	</div>
	<div class="listOfDojos">
				<h3>List of Dojos</h3>

		<c:forEach var="dojo" items="${dojos}">
				<ul>
					<li><a href="/dojos/${dojo.id}/show"><c:out value="${dojo.name}"/></a></li>
				</ul>
				
		</c:forEach>
	</div>

</body>
</html>


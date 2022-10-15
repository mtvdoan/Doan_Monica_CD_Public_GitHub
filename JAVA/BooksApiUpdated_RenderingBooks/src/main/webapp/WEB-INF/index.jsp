<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Book Collection</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
</head>
<body>
	<h1>All Books</h1>
	<table class="table">
	  <thead class="table-light">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Title</th>
			<th scope="col">Language</th>
			<th scope="col"># Pages</th>
		</tr>
	  </thead>
	 <tbody>
		<c:forEach var="book" items="${monicaBooks}">
		<tr>
		<td>${book.id}</td>
		<td>
			<a href="/show/${book.id}">${book.title}</a>
		</td>
		<td>${book.language}</td>
		<td>${book.numberOfPages }</td>
		</tr>
		</c:forEach>
  	</tbody>
	</table>
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

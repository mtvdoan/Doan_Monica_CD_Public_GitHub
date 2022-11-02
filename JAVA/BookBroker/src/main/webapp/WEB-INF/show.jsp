<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>${book.title}</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
	</head>
		<body>
		
		<h1>Book Details</h1>
		<div class="card" style="width: 40rem;">
			<div class="card-header">
				<h3 style="color: blue">Title: ${book.title}</h3>
			</div>
			<div class="card-body">
				<h4 class="card-text">Author: ${book.author}</h4>
				<h6 class="card-subtitle mb-2 text-muted">Thoughts: ${book.thoughts}</h6>
				<h6 class="card-subtitle mb-2 text-muted">Posted By: ${user.userName}</h6>
				<a href="/bookmarket" class="btn btn-info" style="font-size: 1.2rem">Go Back</a>
			</div>
		</div>
		
		</body>
	<script type="text/javascript" src="js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>

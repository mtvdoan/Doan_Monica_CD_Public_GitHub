<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Welcome</title>
<!-- Don't forget to edit your CSS/JS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<head>
<meta charset="UTF-8">
<title>Counter</title>

</head>
<body>

<h2>You visited this server
	(<c:out value="${page}"></c:out>):
	
	<span style="color: red"><c:out value="${doubleCountToShow} "></c:out>times.</span>
</h2>
	



<h2>
<a href="/">Take Another Visit?</a>
</h2>

<h2>
<a href="/reset-doublecounter/" role="button" class="btn btn-success">Reset Counter</a>
</h2>



</body>

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
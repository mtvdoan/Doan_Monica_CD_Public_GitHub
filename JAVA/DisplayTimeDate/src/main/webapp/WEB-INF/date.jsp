
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Display Date</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">


<style>
	*{
		margin: auto;
		padding: 25px;
		max-width: 800px;
		text-align: center;
		white-space: nowrap;
	}
	

</style>
</head>
<body>
	<h1>DATE TEMPLATE</h1>
	<div class="container1">
		<div class="row">
			<h2 class="text-primary">
				<c:out value="${dateString}"></c:out>
			</h2>
		</div>
	</div>
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script>
	alert("Thanks for visiting.  Here's the Date Template.");
</script>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Display Time</title>
<!-- Don't forget to edit your CSS/JS -->
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

<!-- For any Bootstrap that uses JS or jQuery-->
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
	<h1>TIME TEMPLATE</h1>
	<div class="container">
		<div class="row">
			<h2 class="text-success">
				<c:out value="${timeString}"></c:out>
			</h2>
		</div>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script>
	alert("Thanks for visiting.  Here's the Time Template.");
</script>
</body>
</html>

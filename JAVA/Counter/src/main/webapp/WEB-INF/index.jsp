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

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Welcome User</h1>
	<h4>
	<a href="/counter" role="button" class="btn btn-info">Display Visit by Single Increments</a>
	<a href="/doublecounter" role="button" class="btn btn-warning">Display Visit by 2 Increments</a>
	
	</h4>

</body>
</html>

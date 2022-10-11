
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Display Date or Time</title>
<!-- Don't forget to edit your CSS/JS -->
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- For any Bootstrap that uses JS or jQuery-->

</head>
<body>
	<h1>Date or Time?</h1>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h2 class="date">
					<a href="/date/">Date Template</a>
				</h2>
			</div>
			<div class="col-sm-3">
				<h2 class="time">
					<a href="/time/">Time Template</a>
				</h2>
			</div>
		</div>
	</div>
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

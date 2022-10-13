
<!--This is just a sample template.  Change everything as needed.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Omikuji Results</title>
<!-- Don't forget to edit your CSS/JS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />


</head>
<body>
	<div class="container">
		<div class="card w-75 bg-light">
			<div class="card-header w-75">
		           <h1>Omikuji おみくじ Results</h1>
		       </div>
		       <div class="card-body">
		       	<div class="mb-3=">
					<c:out value="${result}"></c:out>
				</div>	
				<a href="/omikuji">Go Back</a>
			</div>
		</div>
	</div>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>


<!--This is just a sample template.  Change everything as needed.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>FruityLoops</title>
<!-- Don't forget to edit your CSS/JS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />


</head>
<body>
	<h1 style="color: pink">Fruit Store</h1>
	<div class="container">
		<table class="table">
		  <thead>
			<tr>
			  <th scope="col">Name</th>
			  <th scope="col">Price</th>
			</tr>
		  </thead>
		  <tbody>
		     <c:forEach var="item" items="${monicaFruits}">
        		
        		<tr>
				  <th scope="row">${item.getName()}</th>
				  <td>${item.getPrice()}</td>
				</tr>
        
    		</c:forEach>
		  </tbody>
		</table>
	</div>
<!-- For any Bootstrap that uses JS or jQuery-->
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

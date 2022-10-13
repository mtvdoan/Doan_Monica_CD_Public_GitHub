
<!--This is just a sample template.  Change everything as needed.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Confirmation Page</title>
<!-- Don't forget to edit your CSS/JS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />


</head>
<body>
	<h1 class="welcome">Confirmation PAGE</h1>
	<div>
<!--   ...   -->
    
    <h3>Pay</h3>
    <form action="/processPayment" method="post">
        <input type="hidden" name="productID" value="128">
        <label>Credit Card Number</label>
        <input type="text" name="creditCardNumber">
        <label>Expiration Date</label>
        <input type="date" name="expDate">
        <input type="submit">
    </form>
    
<!--   ...   -->


	</div>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>

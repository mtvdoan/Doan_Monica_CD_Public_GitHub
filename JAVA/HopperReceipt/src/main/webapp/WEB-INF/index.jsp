<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Hopper's Receipt</title>
	</head>
	<body>
		<h1>Hopper's Receipt</h1>
		<div>
			<h2>Customer's Name: <c:out value = "${fullName}"></c:out></h2>
		</div>
		<div>
			<p style="font-size: 25px">
				<b>Item:</b>
				<c:out value = "${item}"></c:out>
			</p>
		</div>
		<div>
			<p style="font-size: 25px">
				<b>Price: </b>
				$<c:out value = "${cost}"></c:out>
			</p>
		</div>
		
		<div>
			<p style="font-size: 25px">
				<b>Description:</b>
				<c:out value = "${details}"></c:out>
			</p>
		</div>
		<div>
			<p style="font-size: 25px">
				<b>Vendor:</b>
				<c:out value = "${seller}"></c:out>
			</p>
		</div>
	
	</body>
</html>
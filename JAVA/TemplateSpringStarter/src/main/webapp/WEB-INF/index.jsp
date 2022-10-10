
<!--This is just a sample template.  Change everything as needed.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Template Page</title>
<!-- Don't forget to edit your CSS/JS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<h1>TITLE</h1>
	<div>
		<h2>
			This is an example:
			<c:out value="${name}"></c:out>
		</h2>
		<!--Note that whatever goes in ${___} needs to match what set in the controller.  Example)    model.addAttribute("name", name); NEEDS TO MATCH the quoted entry: "name"  -->
	</div>
	<div>
		<p style="font-size: 25px">
			<b>Price:</b>
			<c:out value="${price}"></c:out>
		</p>
	</div>
</body>
</html>

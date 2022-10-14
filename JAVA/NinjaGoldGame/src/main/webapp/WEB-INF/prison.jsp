
<!--This is just a sample template.  Change everything as needed.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Oh No!</title>
    <!-- Don't forget to edit your CSS/JS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
</head>
<style>
</style>
<body>
	<img alt="onsen" src="img/onsen.png">
	<img alt="prisoner" src="img/prisoner.png">
	<h1>Your failed quests and spa habits have landed you in prison</h1>

		<p style="color: red; font-size: 2rem">Game Over!</p>
		<a href="/reset" class="btn btn-primary" style="font-size: 2rem">Play again</a>

</body>
    <script type="text/javascript" src="js/app.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>

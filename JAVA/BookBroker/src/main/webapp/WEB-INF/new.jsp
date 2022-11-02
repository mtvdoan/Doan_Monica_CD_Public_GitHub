<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>New Book Entry</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
</head>
<body>
    <div class="card" style="width: 40rem;">
        <div class="card-header">
            <h2 style="color: blue">Create a New Book</h2>
        </div>
        <div class="card-body">
            <form:form action="/newbook" method="post" modelAttribute="newbook" style="font-size: 1.25rem">
            <p><form:errors path="title" class="text-danger"/></p>
            <p><form:errors path="author" class="text-danger"/></p>
            <p><form:errors path="thoughts" class="text-danger"/></p>
            <p><form:errors path="user" class="text-danger"/></p>
            <form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
            
            <p>
                <form:label path="title">Title: </form:label>
                <form:input path="title"/>
            </p>
            <p>
                <form:label path="author">Author:</form:label>
                <form:input path="author"/>
            </p>
            <p>
                <form:label path="thoughts">Thoughts:</form:label>
                <form:textarea path="thoughts" cols="35" rows="5"/>
            </p>
            <p>Posted By: <c:out value="${user.userName}"></c:out></p>    
            
            <input type="submit" value="Submit" class="btn btn-primary" style="font-size: 1.2rem; margin: 25px"/>
        </form:form>    
        <a href="/bookmarket" class="btn btn-info" style="font-size: 1.2rem">Go Back</a>
    </div>
</div>
</body>
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>

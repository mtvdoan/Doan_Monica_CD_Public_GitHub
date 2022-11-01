<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Book Collection</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
</head>
<body>
    <h1>Welcome, <c:out value="${user.userName}"></c:out>!</h1>
    <div class="tableContainer">
        <table class="table">
            <thead class="table-light">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Thoughts</th>
                    <th scope="col">Posted By</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>
                        <a href="/show/${book.id}">${book.title}</a>
                    </td>
                    <td>${book.author}</td>
                    
                    <td>${book.thoughts}</td>
                    <td>${book.user.userName}</td>
                    <td>
                        <form:form action="/books/${book.id}" method="post" modelAttribute="book" style="font-size: 1.5rem" type="btn btn-alert">
                        <c:choose>
                        <c:when test = "${user.userName == book.user.userName}">
                        <a href="/books/${book.id}/edit" class="btn btn-info">Edit</a>
                        <input type="submit" value="Delete Book" class="btn btn-warning" name="delete" id="delete">
                        <input type="hidden" name="_method" value="delete">
                    </c:when>
                    <c:otherwise>
                    <p>None</p>
                </c:otherwise>
            </c:choose>
            
        </form:form>
    </td>
</tr>
</c:forEach>
</tbody>
<a href="/books/new" class="btn btn-success" style="font-size: 1.2rem">Create a New Book</a>
</table>

<a href="/logout" type="button" class="btn btn-danger" style="font-size: 1.5rem">Logout</a>
</div>
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

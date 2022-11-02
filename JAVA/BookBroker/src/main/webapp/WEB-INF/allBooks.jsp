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
        	<h3>List of All Books</h3>
        <a href="/new" class="btn btn-success">Create a New Book</a>
            <thead class="table-light">
                <tr>
                    <th scope="col">Book ID</th>
                    <th scope="col">Book Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Thoughts by Poster</th>
                    <th scope="col">Posted By</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>
                        <a href="/books/${book.id}">${book.title}</a>
                    </td>
                    <td>${book.author}</td>
                    <td><textarea cols="40" rows="5">${book.thoughts}</textarea></td>
                    <td>${book.user.userName}</td>
					<c:if test = "${book.user.id==user.id}">
	       				<td>
	       					<a href="/books/edit/${book.id}" class="btn btn-warning">Edit</a> 
	       					<a href="/books/delete/${book.id}" class="btn btn-danger">Delete</a>
       					</td>
			    	</c:if>
					<c:if test = "${book.user.id!=user.id}">
			       		<td><a href="/bookmarket/${book.id}" class="btn btn-primary">Borrow</a></td>
			    	</c:if>
				</tr>
		</c:forEach>
		</tbody>
	</table>
</div>


   <div class="tableContainer">
       <table class="table">
           <thead class="table-light">
               <tr>
                   <th scope="col">Book ID</th>
                   <th scope="col">Title</th>
                   <th scope="col">Author</th>
                   <th scope="col">Thoughts by Poster</th>
                   <th scope="col">Posted By</th>
                   <th scope="col">Action</th>
               </tr>
           </thead>
           <tbody>
              <c:forEach var="book" items="${myBooks}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><textarea cols="40" rows="5"><c:out value="${book.thoughts}"></c:out></textarea></td>
				<td><c:out value="${book.user.userName}"></c:out></td>
				<td><a href="/bookmarket/return/${book.id}" class="btn btn-info" >return</a></td>
			</tr>	
		</c:forEach>
</tbody>
<h3>Borrowed Books</h3>
</table>
</div>
<a href="/logout" type="button" class="btn btn-danger" style="font-size: 1.5rem">Logout</a>

<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

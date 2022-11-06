<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Manager - Dashboard</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


	<h1>Welcome, ${user.firstName}	<a href="/logout" class="btn btn-danger">Logout</a></h1>
	
	<div class ="container1">
		<h4>All Projects <a href="/projects/new" type="button" class="btn btn-primary">+ new project</a></h4>
		<table class="table">
			<thead>
			  <tr>
			    <th scope="col">Project</th>
			    <th scope="col">Team Lead</th>
			    <th scope="col">Due Date</th>
			    <th scope="col">Actions</th>
			  </tr>
			</thead>
			<tbody>
			<c:forEach var="project" items="${unassignedProjects}">
				<tr>
				    <c:if test="${project.lead.id != user.id}">
				    <td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
				    <td><c:out value="${project.lead.firstName} ${project.lead.lastName}"></c:out></td>
				    <td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
				    <td>
				    	<a href="/dashboard/join/${project.id}" type="button" class="btn btn-success">Join Team</a>
				    </td>
				    </c:if>
				</tr>
			</c:forEach>
  			</tbody>				    			    
		</table>
	</div>
	
	<div class ="container2">
		<h4>Your Projects</h4>
		<table class="table">
			<thead>
			  <tr>
			    <th scope="col">Project</th>
			    <th scope="col">Lead</th>
			    <th scope="col">Due Date</th>
			    <th scope="col">Actions</th>
			  </tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${assignedProjects}">
					<tr>
						<td><a href="/projects/${project.id}">${project.title}</a></td>
						<td><c:out value="${project.lead.firstName} ${project.lead.lastName}"></c:out></td>
						<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
						<c:if test = "${project.lead.id==user.id}">
					       <td><a href="/projects/edit/${project.id}" class="btn btn-warning">Edit Project</a></td>
					    </c:if>
					    <c:if test = "${project.lead.id!=user.id}">
					       <td><a href="/dashboard/leave/${project.id}" class="btn btn-outline-danger">Leave Team</a></td>
					    </c:if>
					</tr>	
				</c:forEach>
				
  			</tbody>
		</table>
	</div>

</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>


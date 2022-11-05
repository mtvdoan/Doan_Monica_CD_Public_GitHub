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
    <title>Add New Question</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css/">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1 style="color:purple">What is your Question?</h1>
			<h6 style="color: red;">${errorMsg}</h6>

    <hr>
	<div class="container" style="width: 750px; padding: 10px">
		<form:form action="/questions/new" method="post" modelAttribute="question">
			<form:hidden class="input" path="id" value="${id}"/>
		  	<form:errors path="text" class="text-danger"/>
			<div class="container" style="background-color:">
				<div class="mb-3" style="text-align: left; font-weight: bold">
					<form:label path="text" for="question" class="form-label">Question</form:label>
					<form:textarea path="text" class="form-control" id="question" rows="3"></form:textarea>
				</div>
				<div class="mb-3" style="text-align:left; font-weight: bold">
					<form:label for="" path="" class="form-label select-label">Tag</form:label>			
					<form:select multiple="multiple" class="input" path="" data-live-search="true" title="Choose tags that apply..." data-width="500px" style="color: red" name="listOfTags" id="listOfTags">
						<c:forEach var="tag" items="${tags}">
							<form:option style="width: 500px; color: blue; height: 0px" value="${tag.subject}"></form:option>
						</c:forEach>
					</form:select>
					<h6 style="color:green; white-space: nowrap"><i>Hold down the Ctrl (windows) or Command (Mac) button to select multiple tags.</i></h6>
					<button type="submit" class="btn btn-success">Submit</button>
				</div>
  			</div>
  		</form:form>
  	</div>
    <a href="/" type="button" class="btn btn-warning">Home</a>
    <a href="/dashboard" type="button" class="btn btn-info">Dashboard</a>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</html>


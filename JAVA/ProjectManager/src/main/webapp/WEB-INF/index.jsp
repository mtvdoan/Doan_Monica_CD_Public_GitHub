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
    <title>Project Manager - Login/Registration</title>
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


	<h1>Project Manager</h1>
	<h4>Login/Registration</h4>
	<div class ="column1">
	    <div class="card1" style="width: 25rem">
	        <div class="card-header">
	            <h4>Register</h4>
	        </div>
	        <form:form action="/register" method="post" modelAttribute="newUser">            
		        <table>
		            <thead>
		                <tr><form:errors path="firstName" class="text-danger"/></tr>
   		                <tr><form:errors path="lastName" class="text-danger"/></tr>
		                <tr><form:errors path="email" class="text-danger"/></tr>
		                <tr><form:errors path="password" class="text-danger"/></tr>
		                <tr><form:errors path="confirm" class="text-danger"/></tr>
		            </thead>
		            <thead>
		                <tr>
		                    <td class="float-left">First Name:</td>
		                    <td class="float-left">
		                        <form:input class="input" path="firstName"/>
		                    </td>
		                </tr>
                       	<tr>
		                    <td class="float-left">Last Name:</td>
		                    <td class="float-left">
		                        <form:input class="input" path="lastName"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td class="float-left">Email:</td>
		                    <td class="float-left">
		                        <form:input class="input" path="email"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td class="float-left">Password:</td>
		                    <td class="float-left">
		                        <form:input class="input" path="password"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td class="float-left">Confirm PW:</td>
		                    <td class="float-left">
		                    <form:input class="input" path="confirm"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td colspan=2><input class="btn btn-primary" class="button" type="submit" value="Submit"/></td>
		                </tr>
		            </thead>
		        </table>
		    </form:form>
    	</div>
	</div>
	<div class="column2">
	    <div class="card2" style="width: 25rem">
	        <div class="card-header">
	            <h4>Login</h4>
	        </div>
	        <form:form action="/login" method="post" modelAttribute="newLogin">
	            <table>
	                <thead>
	                    <tr>
	                        <form:errors path="email" class="text-danger"/>
	                        <form:errors path="password" class="text-danger"/>
	                    </tr>
	                </thead>
	                <thead>
	                    <tr>
	                        <td class="float-left">Email:</td>
	                        <td class="float-left">
	                            <form:input class="input" path="email"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td class="float-left">Password:</td>
	                        <td class="float-left">
	                            <form:input class="input" path="password"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan=2><input class="btn btn-success" class="button" type="submit" value="Login"/></td>
	                    </tr>
	                </thead>
	            </table>
	    	</form:form>
		</div>
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


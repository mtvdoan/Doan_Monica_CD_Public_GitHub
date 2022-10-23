<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Save Travels - View</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"/>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- c:out ; c:forEach etc. --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Formatting (dates) --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<!-- form:form -->
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- for rendering errors on PUT routes -->
	<%@ page isErrorPage="true" %>
</head>
    <body style="max-width: 960px; margin: auto; text-align: center">
        <h1>Viewing Expense</h1>
        <table class="table" style="max-width: 600px; margin: 10px auto; padding: 0; text-align: center; border: 2px solid black">
            <tbody>
                <tr>
                    <th>Expense Name: </th>
                    <td>
                    <c:out value=" ${viewExpense.expense}"/>
                    </td>
                </tr>
                <tr>
                    <th>Vendor:</th>
                    <td>	
    					<c:out value=" ${viewExpense.vendor}"/>
                    </td>
                </tr>
                <tr>
                    <th>Amount:</th>
                    <td>
                    	<c:out value=" ${viewExpense.amount}"/>
                    </td>
                <tr>
                    <th>Description:</th>
                    <td>
                    	<c:out value=" ${viewExpense.description}"/>	
                    </td>
                </tr>
                <a href="/" class="btn btn-primary btn-sm active" role="button" aria-pressed="true">Go Back</a>
            </tbody>
        </table>
        <script type="text/javascript" src="js/app.js"></script>
        <script src="/webjars/jquery/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script></body>
    </body>    
    </html>
        
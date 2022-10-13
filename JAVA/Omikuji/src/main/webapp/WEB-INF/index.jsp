
<!--This is just a sample template.  Change everything as needed.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Welcome to Omikuji おみくじ </title>
    <!-- Don't forget to edit your CSS/JS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
</head>
<body>
    <div class="card w-75 bg-light">
        <div class="card-header w-75">
            <h3>Omikuji おみくじ Form</h3>
        </div>
        <div class="card-body">
            <form action="/processomikuji" method="post">
                <div class="mb-3=">
                    <label for="">Pick a number between 5-25:</label>
                    <input type="number" id="number" name="number" min="5" max="25">
                </div>
                <div class="mb-3">
                    <label for="">Enter a name of any city:</label>
                    <input class="form-control" type="text" placeholder="City" aria-label="default input example" name="city">
                </div>
                <div class="mb-3">
                    <label for="">Enter a name of a real life person:</label>
                    <input class="form-control" type="text" placeholder="Name of a Person" aria-label="default input example" name="person">
                </div>
                
                <div class="mb-3">
                    <label for="">Enter a professional endeavor or hobby:</label>
                    <input class="form-control" type="text" placeholder="Professional Endeavor or Hobby" aria-label="default input example" name="hobby">
                </div>
                
                <div class="mb-3">
                    <label for="">Enter any type of living thing:</label>
                    <input class="form-control" type="text" placeholder="Living Being" aria-label="default input example" name="living">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Say something nice to someone:</label>
                    <textarea class="form-control" id="message" rows="3" placeholder="Message" name="message"></textarea>
                </div>
                <p>Submit and send to a friend!</p>
                <input type="submit" value="Send"/>
            </form>
        </div>
    </div>
</body>
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>

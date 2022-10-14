
<!--This is just a sample template.  Change everything as needed.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Ninja Gold Game</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
</head>
<style>
</style>
<body>
    <div>
        <div class="yourgold">
            <h1 style="color: orange">Your Gold <c:out value="${gold}"/>
                <img alt="treasure" src="img/treasure.png" style="height:200px; width: 200px; margin: 10px">
            </h1>
        </div>          
        <div class="row">	
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Farm</h5>
                        <img alt="farm" src="img/farm.png" style="height:100px; width: 100px">
                        <p class="card-text">(Earns 10-20 gold)</p>
                        <form action ="/gold" method="post">
                            <input class = "btn btn-success" type="submit" name="farm" value="Find Gold!"/>
                            <img alt="gold" src="img/gold.png" style="height:65px; width: 65px">
                        </form>
                    </div>												
                </div>
            </div>
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Cave</h5>
                        <img alt="cave" src="img/cave.png" style="height:100px; width: 100px">
                        <p class="card-text">(Earns 10-20 gold)</p>
                        <form action ="/gold" method="post">
                            <input class = "btn btn-success" type="submit" name="cave" value="Find Gold!"/>
                            <img alt="gold" src="img/gold.png" style="height:65px; width: 65px">                        	
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">House</h5>
                        <img alt="house" src="img/house.png" style="height:100px; width: 100px">
                        <p class="card-text">(Earns 10-20 gold)</p>
                        <form action ="/gold" method="post">
                            <input class = "btn btn-success" type="submit" name="house" value="Find Gold!"/>
                            <img alt="gold" src="img/gold.png" style="height:65px; width: 65px">                        	
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Quest</h5>
                        <img alt="quest" src="img/quest.png" style="height:100px; width: 100px">
                        <p class="card-text">(Earns/Takes 0-50 gold)</p>
                        <form action ="/gold" method="post">
                            <input class = "btn btn-warning" type="submit" name="quest" value="Find Gold!"/>
                            <img alt="gold" src="img/gold.png" style="height:65px; width: 65px">
                            <img alt="sword" src="img/sword.png" style="height:65px; width: 65px">
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Spa</h5>
                        <img alt="monkey" src="img/monkey.png" style="height:100px; width: 100px">
                        <p class="card-text">(Takes 5-20 gold)</p>
                        <form action ="/gold" method="post">
                            <input class = "btn btn-danger" type="submit" name="spa" value="Treat Yo'Self!"/>
                            <img alt="spa2" src="img/spa2.png" style="height:65px; width: 65px">  
                        </form>
                    </div>
                </div>
            </div>
        </div>	
        <div>
            <form action ="reset" method="post">
                <input class = "btn btn-info" type="submit" name="reset" value="Reset"/>
            </form>
        </div>
        <h2>Activities:</h2>
        <div class ="scrollable" style="border: 1px solid black">
            <c:forEach var="action" items="${actions}">
            <c:if test = "${action.contains('earned')}">
            <p style="color: green;"><c:out value="${action}"></c:out></p>
        </c:if>
        <c:if test = "${action.contains('lost')}">
        <p style="color: red;"><c:out value="${action}"></c:out></p>
    </c:if>
</c:forEach> 
</div>
</div>
</body>
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>

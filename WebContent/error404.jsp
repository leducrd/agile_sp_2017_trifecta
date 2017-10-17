<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
	<head>
		<title>Error-404</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="includes/styles.jsp" %>
	</head>
	
	<body>
	
		<nav class="navbar navbar-inverse">
			<%@ include file="includes/navigation.jsp" %>	
		</nav>
		
		<div class="container col-md-6">
			<img src="assets/images/funnyMechanic.png" class="img-responsive rounded" alt="">
		</div>
		
		<div class="container col-md-6 pull-right" text="center">
				<div class="hero-unit"> 
					<h1>Oh No!</h1>
					<p>The page you're looking for can't be found.</p>
					<p>Don't worry, we're hard at work fixing the problem!</p>
				</div>
		</div>
		
		<%@ include file="includes/scripts.jsp" %>		
	</body>
	
</html>
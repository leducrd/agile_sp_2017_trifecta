<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rides</title>
<%@ include file="includes/styles.jsp" %>
</head>
	<body>
		<nav class="navbar navbar-inverse">
					<%@ include file="includes/navigation.jsp" %>	
		</nav>
	 	<div class="container col-xs-8 col-xs-offset-2">
			<c:choose>
				<c:when test="${empty rides}">
				  	<h1 id="emptyDbHeading">Empty Database</h1>
				    <p id="emptyDbMessage">Sorry, there are no scheduled rides to display. Please try again or <a href="register.jsp">Sign Up!</a></p>
			  	</c:when>
			  	
				<c:otherwise>
	 				<c:forEach items="${rides}" var="ride">
						<div class="row">
					     	<h3 id="eventName">${ride.event}</h3>
					  	</div>
					  <blockquote>
						  <div class="row">
						  	Destination: ${ride.destination}
						  </div>
						  
						  <div class="row">
						  	Leave Time: ${ride.leaveTime}
						  </div>
						  
						  <div class="row">
						  	Return Time: ${ride.returnTime}
						  </div>
						  
						  <div class="row">
						  	Reason: ${ride.reason}
						  </div>
					  </blockquote>
	  				</c:forEach>
	  			</c:otherwise>
			</c:choose>	
		</div>
	
		<footer class="container col-xs-12 text-center" id="footer">
			<div class="row">
				<%@ include file="includes/footer.jsp" %>
			</div>	
		</footer>
		
		<%@ include file="includes/scripts.jsp" %>		
	</body>
</html>
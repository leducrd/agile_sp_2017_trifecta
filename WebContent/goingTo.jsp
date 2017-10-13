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
			  	<h1>Error</h1>
			    <p>Sorry, the login credentials you provided are incorrect.  Please try again or <a href="register.jsp">Sign Up</a></p>
			  	</c:when>
			  	
				<c:otherwise>
	 				<c:forEach items="${rides}" var="ride">
						<div class="row">
					    <div class="col">
					     	<p> Event Name: ${ride.event}</p>
						</div>
					  </div>
					  
					  <div class="row">
					    <div class="col">
					      Destination:
					    </div>
					    <div class="col-6">
					      ${ride.destination}
					    </div>
					  </div>
					  
					  <div class="row">
					    <div class="col">
					      Leave Time:
					    </div>
					    <div class="col-6">
					      ${ride.leaveTime}
					    </div>
					  </div>
					  
					  <div class="row">
					    <div class="col">
					      Return Time:
					    </div>
					    <div class="col-6">
					      ${ride.returnTime}
					    </div>
					  </div>
					  
					  <div class="row">
					  	<div class="col">
					    		Reason:
					    </div>
						<div class="col-6">
							${ride.reason}
						</div>
					  </div>
					  <br>
	      
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
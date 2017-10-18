<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">

	<head>
		<title>User Profile</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="includes/styles.jsp" %>
	</head>
	
	<body>
	
		<nav class="navbar navbar-inverse">
			<%@ include file="includes/navigation.jsp" %>	
		</nav>
		
		<div class="container-fluid text-center profilebg">
			<img src="assets/images/profile_default.jpg" alt="default profile image" class="img-rounded"/>
			
			<div class="container-fluid">
				<%-- <c:forEach var="person" items="${people}"> --%>
					<h1>${people.firstName}${people.lastName}</h1>
					<p>Your User Type: ${people.userType}</p>		
					<br>
			        <p>Phone: ${people.phoneNumber}</p>
			        <p>Email: ${people.email}</p>
			        <p>Password: ${people.password}</p>
	
					<h3>Your Vehicle</h3>
					<c:choose>
							<c:when test="${empty vehicle}">
								<p>None on file</p>								
							</c:when>
							<c:otherwise>	
								<p>${vehicle.year} ${vehicle.make} ${vehicle.model}</p>			        
						      	<p>Color: ${vehicle.color}</p>
						      	<p>Max Seats: ${vehicle.maxSeats}</p>
						    		<p>Smoking permitted: ${vehicle.canSmoke}</p>  
							</c:otherwise>
						</c:choose>
					
				<%-- </c:forEach> --%>
			</div>
		
			
		</div>
		
	</body>
</html>


						
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">

	<head>
		<title>Profile</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="includes/styles.jsp" %>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	</head>
	
	<body>
	
		<nav class="navbar navbar-inverse">
			<%@ include file="includes/navigation.jsp" %>	
		</nav>
		
		<div class="container-fluid text-center userprofilebg">
				<%-- <c:forEach var="person" items="${people}"> --%>
				
			        <img src="assets/images/profile_default.jpg" alt="default profile image" class="img-rounded"/>
					<h1>${people.firstName}${people.lastName}</h1>
			        <p>Phone: ${people.phoneNumber}</p>
			        <p>Email: ${people.email}</p>
			        <p>Password: ${people.password}</p>
			        <p>User Type:</p> ${people.userType}</p>
			        
			        <c:choose>
							<c:when test="${empty people}">
								<li><a href="register.jsp">Sign Up</a></li>								
							</c:when>
							<c:otherwise>
								<li><a href="userProfile.jsp">Profile</a></li>
								<li><a href="request.jsp">Request a Ride</a></li>
								<li><a href="DriverReview.jsp">Driver Review</a></li>
								<li><a>Log Out</a></li>
							</c:otherwise>
						</c:choose>
			        
			        
			        
			        <h3>Your Vehicle</h3>
					<p>Make: ${vehicle.make} </p>
			        <p>Model: ${vehicle.model}</p>
			        <p>Year: ${vehicle.year}</p>
			        <p>Color: ${vehicle.color}</p>
			        <p>Max Seats: ${vehicle.maxSeats}</p>
			      	<p>Can Smoke?: ${vehicle.canSmoke }</p>
			    <%-- </c:forEach> --%>		
			
			</div>
		
		</div>
		
	</body>
</html>
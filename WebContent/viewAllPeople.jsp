<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Can't Log in</title>
	</head>
	<body>
	
		
		<p>${message }</p>
		
		<c:choose>
		  <c:when test="${empty people}">
		  	<h1>Error</h1>
		    <p>Sorry, the login credentials you provided are incorrect.  Please try again or <a href="register.jsp">Sign Up</a></p>
		  </c:when>
		  <c:otherwise>
		  <h1>Logged In</h1>
		    <%-- <c:forEach var="person" items="${people}"> --%>
		      <div class="span4">
		        <h4>${people.firstName}, ${people.lastName}</h4>
		        <p>Phone: ${people.phoneNumber}</p>
		        <p>Email: ${people.email}</p>
		        <p>Password: ${people.password}</p>
		        <p>User Type: ${people.userType}</p>
		      </div>
		    <%-- </c:forEach> --%>
		  </c:otherwise>
		 
		</c:choose>
	</body>
</html>
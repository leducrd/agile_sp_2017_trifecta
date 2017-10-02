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
	
		<h1>Cannot Log In</h1>
		<p>${message }</p>
		
		<c:choose>
		  <c:when test="${empty people}">
		    <p>Sorry, there are no people listed</p>
		  </c:when>
		  <c:otherwise>
		    <c:forEach var="people" items="${people}">
		      <div class="span4">
		        <h4>${person.firstName}, ${person.lastName}</h4>
		        <p>Phone: ${person.phoneNumber}</p>
		        <p>Email: ${person.email}</p>
		        <p>Password: ${person.password}</p>
		      </div>
		    </c:forEach>
		  </c:otherwise>
		 
		</c:choose>
	</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Error</title>
		<meta name="description" content="This is a JSP page that shows an Error response
		page for when a problem occurs.">
		<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
		<div class="container">
			<div class="hero-unit">
				<h1>Error</h1>
			</div>
			<div class="container">
				<p>"I'm out of order? You're out of order! This whole courtroom's out of order!"</p> 
				<c:choose>
					<c:when test="${message != null}">
						<p>${message}</p>
					</c:when>
				<c:otherwise>
					<p>Click the back button.</p>
					<p><strong>Error Details</strong></p>
					<p>Type: ${pageContext.exception["class"]}</p>
					<p>Message: ${pageContext.exception.message}</p>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</body>

</html>
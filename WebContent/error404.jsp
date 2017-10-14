<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<<<<<<< HEAD
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="This is a JSP page that shows a 404 response page for when a 
				page is not found.">
		<%@ include file="includes/styles.jsp" %>
=======
>>>>>>> master
		<title>404 - Page Not Found</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="includes/styles.jsp" %>
	</head>
	
	<body>
		<div class="container col-xs-6">
			<img src="" class="rounded float-left" alt="">
		</div>
		
		<div class="container col-xs-6 pull-right">
				<div class="hero-unit"> 
					<h1>404</h1>
				</div>
				<div class="container">
					<p>This is not the page you are looking for.</p>
					<p>To continue, click the Back button.</p>
				</div>
		</div>
		
		<%@ include file="includes/scripts.jsp" %>		
	</body>
	
</html>
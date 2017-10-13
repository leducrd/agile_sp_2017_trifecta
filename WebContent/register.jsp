<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">

	<head>
		<title>Register Now</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="includes/styles.jsp" %>
	</head>
	
	<body>
	
		<nav class="navbar navbar-inverse">
			<%@ include file="includes/navigation.jsp" %>	
		</nav>
		
		<div>
			<main class="container col-xs-10 col-xs-offset-1">
				<div>
					<h2>Sign up to Ride!</h2>
					<p>Fill out the form below. Required fields are marked with an asterisk *</p>
	
					<form method="post" action="AddPerson">
						<fieldset>
							<label for="firstName">*First Name:</label>
							<br>
							<input type="text" size="50" name="firstName" id="firstName" required="required">
							<br>
			
							<label for="lastName">*Last Name:</label>
							<br>
							<input type="text" size="50" name="lastName" id="lastName" required="required">
							<br>
			
							<label for="myEmail">*E-mail (example@domain.com):</label>
							<br>
							<input type="email" size="50" name="myEmail" id="myEmail" required="required">
							<br>
			
							<label for="number">*Phone Number (XXX-XXX-XXXX):</label>
							<br>
							<input type='tel' pattern="^\d{3}-\d{3}-\d{4}$"  title='Phone Number (Format: XXX-XXX-XXXX)' name="number" id="number" required="required">
							<br>
							
							<label for="password">*Password:</label>
							<br>
							<input type='password' title='Password' name="password" id="password" required="required">
							<br><br>	
							<p>I am a:</p>
							<input type="checkbox" title="UserType" name="userType" id="rider" value="r"><label for="rider">Rider</label><br>
							<input type="checkbox" title="UserType" name="userType" id="driver" value="d" data-toggle="collapse" data-target="#driverAdditionalInfo"><label for="driver">Driver</label>
							
<!-- 							<div class="collapse" id="driverAdditionalInfo">
							
								<h5>Please provide the following information to become a driver</h3>
							
								<label for="carMake">Make</label>
								<br>
								<input type="text" size="50" required="required">
								<br>
								
								<label for="carModel">Model</label>
								<br>
								<input type="text" size="50" required="required">
								<br>
								
								<label for="carMake">Year</label>
								<br>
								<input type="text" size="50" required="required">
								<br>
								
								<label for="carMake">Color</label>
								<br>
								<input type="text" size="50" required="required">
								<br>
								
								<label for="carMake">Max Seats</label>
								<br>
								<input type="number" size="50" required="required">
								<br>
								
								<label for="carMake">Can Smoke?</label>
								
							</div> -->
							
						</fieldset>
						<br>
						<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-default"> 
					</form>
					<br>
				</div>
			</main>

		</div>
		
		<footer class="container col-xs-12 text-center" id="footer">
			<div class="row">
				<%@ include file="includes/footer.jsp" %>
			</div>	
		</footer>
		
		<%@ include file="includes/scripts.jsp" %>
	</body>
</html>
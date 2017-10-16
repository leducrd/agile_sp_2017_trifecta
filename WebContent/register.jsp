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
							<input type="checkbox" title="UserType" name="userType" id="driver" value="d" data-toggle="collapse" data-target="#additionalDriverInfo"><label for="driver">Driver</label>
							
							<div class="collapse" id="additionalDriverInfo">
							
								<label for="make">*Make:</label>
								<br>
								<select name="make" id="make" width="50">					
									<option value="Acura">Acura</option>
									<option value="Audi">Audi</option>
									<option value="BMW">BMW</option>
									<option value="Buick">Buick</option>
									<option value="Cadillac">Cadillac</option>
									<option value="Chevrolet">Chevrolet</option>
									<option value="Chrysler">Chrysler</option>
									<option value="Dodge">Dodge</option>
									<option value="Ferrari">Ferrari</option>
									<option value="Fiat">Fiat</option>
									<option value="Ford">Ford</option>
									<option value="GMC">GMC</option>
									<option value="Honda">Honda</option>
									<option value="Hundai">Hundai</option>
									<option value="Infiniti">Infiniti</option>
									<option value="Jaguar">Jaguar</option>
									<option value="Jeep">Jeep</option>
									<option value="Kia">Kia</option>
									<option value="Lexus">Lexus</option>
									<option value="Mazda">Mazda</option>
									<option value="Mercedes-Benz">Mercedes-Benz</option>
									<option value="Mini">Mini</option>
									<option value="Mitsubishi">Mitsubishi</option>
									<option value="Nissan">Nissan</option>
									<option value="Porsche">Porsche</option>
									<option value="Saab">Saab</option>
									<option value="Subaru">Subaru</option>
									<option value="Tesla">Tesla</option>
									<option value="Toyota">Toyota</option>
									<option value="Volkswagen">Volkswagen</option>
									<option value="Volvo">Volvo</option>				
								</select>
								<br>
				
								<label for="model">*Model:</label>
								<br>
								<input type="text" size="50" name="model" id="model" required="required">
								<br>
								
								<label for="year">*Year (Must be 2007 or newer):</label>
								<br>
								<select name="year" id="year">
									<option value="2007">2007</option>
									<option value="2008">2008</option>
									<option value="2009">2009</option>
									<option value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
								</select>
								<br>
				
								<label for="color">*Color:</label>
								<br>
								<select name="color" id="color">
									<option value="Black">Black</option>
									<option value="Blue">Blue</option>
									<option value="Green">Green</option>
									<option value="Orange">Orange</option>
									<option value="Red">Red</option>
									<option value="White">White</option>
									<option value="Yellow">Yellow</option>
								</select>
								<br>
								
								<label for="maxSeats">*Max Seats:</label>
								<br>
								<select name="maxSeats" id="maxSeats">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
								</select>
								<br>
				
								<label for="canSmoke">*Can Smoke:</label>
								<br>
								<input type="radio" name="canSmoke" value="Yes"/> Yes
								<input type="radio" name="canSmoke" value="No"/> No
								<br>
								
							</div>
							
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
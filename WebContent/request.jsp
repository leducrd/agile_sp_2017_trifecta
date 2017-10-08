<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">

	<head>
		<title>Request a Ride</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="includes/styles.jsp" %>
		<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
	</head>
	
	<body>
	
		<nav class="navbar navbar-inverse">
			<%@ include file="includes/navigation.jsp" %>	
		</nav>
		
		<div id="map"></div>
		
		<main class="container">
			<h2>Request a Ride</h2>
			<p>Fill out the form below. Required fields are marked with an asterisk *</p>
			<form method="post" action="RideRequest">
				<fieldset>
					<label for="userID">*UserID:</label>
					<br>
			
					<input type="text" size="50" name="userID" id="userID" required="required">
					<br>
			
					<label for="event">*Event:</label>
					<br>
			
					<input type="text" size="50" name="event" id="event" required="required">
					<br>
			
			
					<label for="destination">*Destination:</label>
					<br>
			
					<input type="text" size="50" name="destination" id="destination" required="required">
					<br>
			
					<label for="leave">*Leave date and time:</label>
					<br>
					<input type="text"  title='leave' name="leave" id="leave" required="required">
					<br>
					
					<label for="return">*Return date and time:</label>
					<br>
					<input type="text"  title='return' name="return" id="return" required="required">
					<br>
					
					<label for="reason">*Reason for going:</label>
					<br>
			
					<textarea name="reason" id="reason" cols="20" rows="2"></textarea>				
			
				</fieldset>
				<br>
				<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-default"> </form>
			<br>
			
			<script>
				function initMap() {
					var location = {lat: 44.862234, lng: -91.482216};
					var map = new google.maps.Map(document.getElementById("map"), {
						zoom: 4,
						center: location			
					});
				}
			</script>
			<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAkHNsQhmsFP4irT3TbTmFHWfPYVXj9vSU&callback=initMap"></script>
			
		</main>
		
		<footer class="container footer text-center">
			<%@ include file="includes/footer.jsp" %>	
		</footer>
		
		<%@ include file="includes/scripts.jsp" %>
	</body>
</html>
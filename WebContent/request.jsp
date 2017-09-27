<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Request a Ride</title>
	</head>
	<body>
	<h2>Request a Ride</h2>
	<form method="post" action="AddPerson">
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
	
		<input type="submit" name="submit" id="submit" value="Submit"> </form>
		<br>
	
	</body>
</html>
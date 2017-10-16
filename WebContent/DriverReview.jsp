<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html lang="en-US">

		<head>
			<title>Driver Review</title>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<%@ include file="includes/styles.jsp" %>
				<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
		</head>

		<body>

			<nav class="navbar navbar-inverse">
				<%@ include file="includes/navigation.jsp" %>
			</nav>

			<main class="container">
				<h2>Driver Review</h2>
				<p>Fill out the form below to write a review on the driver. Required fields are marked with an asterisk *</p>
				<form method="post" action="DriverReview">
					<fieldset>
						<label for="userID">*UserID:</label>
						<br>

						<input type="text" size="50" name="userID" id="userID" required="required">
						<br>

						<label for="driverName">*Driver's name:</label>
						<br>

						<input type="text" size="50" name="driverName" id="driverName" required="required">
						<br>

						<div class="stars">
							<br>
							<label for="rating">*Rating:</label>
							<br>
							<input class="star star-5" id="star-5" type="radio" name="star" />
							<label class="star star-5" for="star-5"></label>
							<input class="star star-4" id="star-4" type="radio" name="star" />
							<label class="star star-4" for="star-4"></label>
							<input class="star star-3" id="star-3" type="radio" name="star" />
							<label class="star star-3" for="star-3"></label>
							<input class="star star-2" id="star-2" type="radio" name="star" />
							<label class="star star-2" for="star-2"></label>
							<input class="star star-1" id="star-1" type="radio" name="star" />
							<label class="star star-1" for="star-1"></label>
				</div>

				<br>

				<label for="review">*Review</label>
				<br>

				<textarea name="review" id="review" cols="20" rows="2"></textarea>

				</fieldset>
				<br>
				<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-default">
				</form>
				<br>
			</main>

			<footer class="container footer text-center">
				<%@ include file="includes/footer.jsp" %>
			</footer>

			<%@ include file="includes/scripts.jsp" %>
		</body>

		</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>NotYet-Home</title>
		<%@ include file="includes/stylesheets.jsp" %>
	</head>
	<body id="wrapper">
		<nav class="navbar navbar-inverse">
			<%@ include file="includes/navigation.jsp" %>	
		</nav>
		
		<div class="container">	 

			<header>
				<h1 class="text-center">Not Yet Carpool Service</h1>  
			</header>
			
			<figure class="text-center">
				<img class="figure-img img-fluid" src="assets/images/home-driver.jpg" alt="Driver Photo">
			</figure>
				
			<section class="content">				
 				<h2>About Us</h2>
 					
				<p>This is the reason we exist.  These are the problems that we are passionate
				about solving. This is the unique and important information regarding our
				carpool service and why you will want to utilize it. These are our strong points 
				that we'd like to express. And these are our selling points, such as low rates, 
				high safety, excellent ratings and the reasons behind them.</p>
				
				<p>We strive to be your car-pooling experts by connecting local commuters
				and assisting in providing safe, convenient travel options. Based your pickup
				and drop-off locations, we do our absolute best to find a solution so that you're able to 
				 connect with others along a similar path.  Don't take our word for it. Get it
				 straight from our user's testimonials below!</p>
			</section>
 				
			<section class="content">	 
				 <h2>Testimonials</h2>
				 
				 <blockquote class="blockquote">
				 What a great idea! This is exactly what this area has been in need of for a number of
				 years now. I've personally cut the mileage on my car in half since I started using NotYet!
				 <div class="blockquote-footer">
				 	- Marque Mark
				 </div>
				 </blockquote>

				 <blockquote class="blockquote">
				 This is just the most unbelievably wonderful organization I've ever worked with. And believe
				 me, I've worked with more organizations than anyone alive! Great people. Great people.
				 <div class="blockquote-footer">
				 	- Donny John
				 </div>
				 </blockquote>
			 
			</section>
			
			<footer class="footer text-right">
				<%@ include file="includes/footer.jsp" %>	
			</footer>
											
		</div><!-- content container (makes this page responsive) -->
	
		<%@ include file="includes/scripts.jsp" %>
		
	</body>
	
</html>
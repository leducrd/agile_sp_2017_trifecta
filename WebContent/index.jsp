<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">

	<head>
		<title>NotYet-Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ include file="includes/styles.jsp" %>
	</head>
	
	<body>
	
		<nav class="navbar navbar-inverse">
			<%@ include file="includes/navigation.jsp" %>	
		</nav>
		
		<section id="mainBannar">
			<div class="container col-xs-12">
				<div class="jumbotron text-center">	 
					<h1>Not Yet Carpool Service</h1> 
					<a href="#loginForm" data-toggle="collapse">Login Now!</a>	
					<%@ include file="includes/loginForm.jsp" %>	
				</div>
			</div>
		</section>
		
		<div>		
			<section class="container">
				<div class="row">
					<div id="aboutUsContent" class="col-xs-12 text-center">				
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
					 </div>
				 </div>
			</section>
											
		</div>
		
<<<<<<< HEAD
		<div class="container col-xs-11" id="testimonialOuterBoarder">
=======
		<div class="container col-xs-10 col-xs-offset-1" id="testimonialOuterBoarder">
>>>>>>> html
			<h2>Testimonials</h2>
			
			<div class="container">
				<div class="row">
<<<<<<< HEAD
					<div class="col-xs-11">
=======
					<div class="container col-xs-12">
>>>>>>> html
						
						<div id="testimonialSlider" class="carousel slide" data-ride="carousel">
							
							<!-- Indicators or "dot nav" -->
							<ol class="carousel-indicators">
								<li data-target="#testimonialSlider" data-slide-to="0" class="active"></li>
								<li data-target="#testimonialSlider" data-slide-to="1"></li>
								<li data-target="#testimonialSlider" data-slide-to="2"></li>
							</ol>
								
							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
								
								<div class="item active">
									<img src="assets/images/MarqueMark.jpg" alt="Marque Mark" class="img-rounded"/>
									<div class="carousel-caption">
												<p>"What a great idea! This is exactly what this area has been in need of for a number of
						 						years now. I've personally cut the mileage on my car in half since I started using NotYet!"<br>-Marque Mark</p>
									</div>
								</div>
									
								<div class="item">
									<img src="assets/images/DonJohn.jpg" alt="Don John" class="img-rounded"/>
									<div class="carousel-caption">
												<p>"This is just the most unbelievably wonderful organization I've ever worked with. And believe
					 							 me, I've worked with more organizations than anyone alive! Great people!"<br>-Don John</p>
									</div>
								</div>
								
								<div class="item">
									<img src="assets/images/CyndiLauper.jpg" alt="Cyndi Lauper" class="img-rounded"/>
									<div class="carousel-caption">
												<p>"This is like totally the best and coolest rideshare service ever!"<br>-Cyndi Lauper</p>
									</div>
								</div>
							</div>
							
							<!-- controls or next and prev buttons -->
								
							<a class="left carousel-control" href="#testimonialSlider" role="button" data-slide="prev">
								<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a>
								
							<a class="right carousel-control" href="#testimonialSlider" role="button" data-slide="next">
								<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>
						</div>
					</div>
					
				</div>
				
			</div>
		</div>
<<<<<<< HEAD
		<section class="container">
			<footer class="footer text-center">
				<%@ include file="includes/footer.jsp" %>	
			</footer>
		</section>
=======
		<br>
		<footer class="container footer text-center">
			<%@ include file="includes/footer.jsp" %>	
		</footer>
	
>>>>>>> html
		<%@ include file="includes/scripts.jsp" %>
		
	</body>
	
</html>
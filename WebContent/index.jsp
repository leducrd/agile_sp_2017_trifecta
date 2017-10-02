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
			<%@ include file="includes/loginForm.jsp" %>
			
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
			
			<h2>Testimonials</h2>
			
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-12">
					
						<div id="testimonialSlider" class="carousel slide" data-ride="carousel">
						
							<!-- Indicators or "dot nav" -->
							<ol class="carousel-indicators">
								<li data-target="#testimonialSlider" data-slide-to="0" class="active"></li>
								<li data-target="#testimonialSlider" data-slide-to="1"></li>
								<!-- <li data-target="#testimonialSlider" data-slide-to="2"></li>-->
							</ol>
							
							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
							
								<div class="item active">
									<img src="assets/images/MarqueMark.jpg" alt="Marque Mark"/>
									<div class="carousel-caption">
											<blockquote>
												<p>What a great idea! This is exactly what this area has been in need of for a number of
					 							years now. I've personally cut the mileage on my car in half since I started using NotYet!</p>p>
					 							<footer>Marque Mark</footer>
					 						</blockquote>
									</div>
								</div>
								
								<div class="item">
									<img src="assets/images/DonJohn.jpg" alt="Don John"/>
									<div class="carousel-caption">
											<blockquote>
												<p>This is just the most unbelievably wonderful organization I've ever worked with. And believe
				 								 me, I've worked with more organizations than anyone alive! Great people. Great people!</p>p>
					 							<footer>Don John</footer>
					 						</blockquote>
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
			
 			<!--  	
			<section class="content">	 
				 <h2>Testimonials</h2>git 
				 
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
			-->
			<footer class="footer text-right">
				<%@ include file="includes/footer.jsp" %>	
			</footer>
											
		</div><!-- content container (makes this page responsive) -->
	
		<%@ include file="includes/scripts.jsp" %>
		
	</body>
	
</html>

			<div class="container-fluid">
			
				<!--  Logo -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="index.jsp" class="navbar-brand">Logo Here</a>
				</div>
				
				<!-- Menu Items -->
				<div class="collapse navbar-collapse" id="mainNavBar">
					<ul class="nav navbar-nav">
						<li><a href="index.jsp">Home</a></li>
					
						<c:choose>
							<c:when test="${empty people}">
								<li><a href="register.jsp">Sign Up</a></li>								
							</c:when>
							<c:otherwise>
								<li><a href="userProfile.jsp">Profile</a></li>
								<li><a href="request.jsp">Request a Ride</a></li>
								<li><a href="DriverReview.jsp">Driver Review</a></li>
								<li><a href="logout.jsp">Log Out</a></li>
							</c:otherwise>
						</c:choose>
						
					</ul>
				</div>
				
			</div>
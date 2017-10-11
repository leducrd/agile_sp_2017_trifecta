<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rides</title>
</head>
<body>

 <div class="container">
<c:forEach items="${rides}" var="ride">
  <div class="row">
    <div class="col">
      <p>Event Name:</p>
    </div>
    <div class="col-6">
		${rides.event}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Destination:
    </div>
    <div class="col-6">
      ${rides.destination}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Leave Time:
    </div>
    <div class="col-6">
      ${rides.leave}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Return Time:
    </div>
    <div class="col-6">
      ${rides.return}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Reason:
    </div>
    <div class="col-6">
      ${rides.reason}
    </div>
  </div>
  </c:forEach>
</div>
<footer class="container footer text-center">
			<%@ include file="includes/footer.jsp" %>	
		</footer>
	

		<%@ include file="includes/scripts.jsp" %>
		
</body>
</html>
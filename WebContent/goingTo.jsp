<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="container">
<c:forEach items="${ride}" var="ride">
  <div class="row">
    <div class="col">
      Event Name:
    </div>
    <div class="col-6">
		${ride.event}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Destination:
    </div>
    <div class="col-6">
      ${ride.destination}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Leave Time:
    </div>
    <div class="col-6">
      ${ride.leave}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Return Time:
    </div>
    <div class="col-6">
      ${ride.return}
    </div>
  </div>
  <div class="row">
    <div class="col">
      Reason:
    </div>
    <div class="col-6">
      ${ride.reason}
    </div>
  </div>
  </c:forEach>
</div>
</body>
</html>
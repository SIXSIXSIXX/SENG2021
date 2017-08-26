<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,dataBase.Makes,searchResult.SearchResult, dataBase.Model, booking.Request"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/dealerBookingList.css">
</head>
<body>
<div class="txt">
	<h1>Dealer Booking Management</h1>
</div>

<div class="dealerBookingList">
<form action=Control method="get">
	<button class="btn" name="pending" type="submit">Pending</button>	
	<button class="btn" name="accepted" type="submit">Accepted</button>	
	<button class="btn" name="rejected" type="submit">Rejected</button>
	<a href="addAvailableCar.jsp" class="btn">Add Available Car</a>
</form>
	<div class="result">
	<%String type = userInfo.getCurrentList(); 
	String visible ="inline";
	if(!type.equals("pending")){
		visible = "none";
	}
	System.out.println(visible);
	%>
		<ul>
			<li style="font-size:27px">Car name</li>
			<li style="font-size:27px">Booking time</li>
			<li style="font-size:27px">Client name</li>
			<li style="font-size:27px">Contact number</li>
			<li style="font-size:27px">Client address</li>
			<li style="font-size:27px">Distance</li>
			<li style="font-size:27px; display:<%=visible%>">Operation</li>
		</ul>
		  <%

		for (String requestId : userInfo.getDisplayList()) {
			Request currRequest = new Request(requestId,"Dealer");
		%>
        <ul>
			<li><a href="carDetail.jsp?id=<%=currRequest.getID()%>"><%=currRequest.getModelName()%></a></li>
            <li><%=currRequest.getBookTime()%></li>
			<li><%=currRequest.getName()%></li>
			<li><%=currRequest.getPhone()%></li>
			<li><%=currRequest.getAddress()%></li>
			<li><%=currRequest.getDistance()%></li>
			<li style ="display:<%=visible%>"><form action=Control method="get">
			  <button class="btn btn-primary" name="accept" value="<%=requestId%>">Accept</button>
			  <button class="btn btn-primary" name="reject" value="<%=requestId%>">Reject</button>
			</form></li>
		</ul>
  <%
  	}
	%>
	</div>	  
</div>

</body>
</html>
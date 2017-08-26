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
	<link rel="stylesheet" type="text/css" href="style/clientBookingList.css">
</head>
<body>
<div class="txt">
	<h1>Client Booking Management</h1>
</div>
<form action=Control method="get">
<div class="dealerBookingList">
	<button class="btn" name="pending" type="submit">Pending List</button>	
	<button class="btn" name="accepted" type="submit">Accepted List</button>	
	<div class="result">
		<ul>
			<li style="font-size:27px">Car name</li>
			<li style="font-size:27px">Booking time</li>
			<li style="font-size:27px">Dealer name</li>
			<li style="font-size:27px">Contact number</li>
			<li style="font-size:27px">Dealer address</li>
			<li style="font-size:27px">Distance</li>
		</ul>
		  <%

		for (String requestId : userInfo.getDisplayList()) {
			System.out.println("aaaa"+requestId);
			Request currRequest = new Request(requestId,"Public");
		%>
        <ul>
			<li><a href="carDetail.jsp?id=<%=currRequest.getID()%>"><%=currRequest.getModelName()%></a></li>
            <li><%=currRequest.getBookTime()%></li>
			<li><%=currRequest.getName()%></li>
			<li><%=currRequest.getPhone()%></li>
			<li><%=currRequest.getAddress()%></li>
			<li><%=currRequest.getDistance()%></li>
			<li style="display:none;"><div class="btn-group"></div></li>
		</ul>
  <%
  	}
	%>
	</div>	  
</div>
</form>

</body>
</html>